package com.javaweb_week.salefood.controller;

import com.javaweb_week.salefood.entity.Foods;
import com.javaweb_week.salefood.entity.Meat;
import com.javaweb_week.salefood.entity.MeatB;
import com.javaweb_week.salefood.entity.Rstmanager;
import com.javaweb_week.salefood.repository.MeatRepository;
import com.javaweb_week.salefood.service.FoodsService;
import com.javaweb_week.salefood.service.MeatService;
import com.javaweb_week.salefood.service.RstmanagerService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


@Controller
public class ControllerB {


    @Autowired
    private RstmanagerService rstmanagerService;
    @Autowired
    private FoodsService foodsService;
    @Autowired
    private MeatService meatService;

    @Autowired
    private MeatRepository meatRepository;

    //localhost：8080/RstManager_Login
    //食堂管理员登录
    @RequestMapping("/RstManager_Login")//action="RstManager_Login"
    public String RstManagerLogin(String rmusername, String rmpassword, Map<String, Rstmanager> map) {
        Rstmanager rstManager = rstmanagerService.RstManagerLogin(rmusername, rmpassword);
        if (rstManager != null) {//判断输入的账号和密码是正确
            map.put("rstManager", rstManager);
            return "RstManager_main";
        } else {
            return "RstManager_Login";
        }
    }


    //返回主页面
    @RequestMapping("/return_main")
    public String returnTomain() {
        return "RstManager_main";
    }


    //获取菜组信息(相当于总表详情)
    @RequestMapping("/get_Foods")
    public String getFoods(Map<String, Object> map) {
        List<Foods> foods = foodsService.selectFoods();
        map.put("foods", foods);
        return "Foods";//Foods.html
    }

    //进入添加菜组页面（菜组表）
    @GetMapping(value = "/add_Foods")
    public String addFoods() {
        return "add_Foods";
    }

    //实际完成添加业务
    @PostMapping(value = "/add_Foods")
    public String addFoods(Foods foods) {
        foodsService.insertFoods(foods);
        return "RstManager_main";
    }


    //修改的预处理，通过菜组编号Fid获取当前记录
    @RequestMapping(value = "f_update", method = RequestMethod.GET)
    public String updateFoodsPre(int Fid, Model model) {
        Foods foods = foodsService.selectFoodsById(Fid);
        model.addAttribute("foods", foods);
        return "update_Foods";//进入修改页面
    }

    //实际的修改
    @RequestMapping(value = "/update_Foods", method = RequestMethod.POST)
    public String updateFoods(Foods foods) {
        foodsService.updateFoodsById(foods);
        return "RstManager_main";
    }

    //Foods表，删除完成后 需要重新获取删除后的新的数据，再显示
    @RequestMapping("/f_delete")
    public String deleteFoods(int Fid) {
        foodsService.deleteFoodsById(Fid);
        return "RstManager_main";
    }

    //显示对应菜组所有的菜品
    @RequestMapping("/f_meat")
    public String getMeat(Integer Fid, Map<String, Object> map) {
        List<Meat> meat = meatService.selectMeat(Fid);
        map.put("meat", meat);
        return "Meat";//Meat.html
    }

    //进入添加菜品页面（菜品表Meat）
    @GetMapping(value = "/add_Meat")
    public String addMeat() {
        return "add_Meat";
    }

    //private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ControllerB.class);

    //实际完成添加业务
    @PostMapping(value = "/add_Meat")
    public String addMeat(@RequestParam("Meatid") Integer Meatid,
                          @RequestParam("Mname") String Mname,
                          @RequestParam("Mstyle") String Mstyle,
                          @RequestParam("Mprice") Double Mprice,
                          @RequestParam("Mpicture") MultipartFile Mpicture,
                          Map<String, String> map) {
        String msg;
        List<MeatB> re = meatRepository.findMeatBByMname(Mname);
        if (Mpicture.isEmpty()) {
            msg = "图片不能为空!";
            map.put("msg", msg);
            return "RstManager_main";
        } else if (re.size() != 0) {
            msg = "存在同名菜品！！";
            map.put("msg", msg);
            return "RstManager_main";


        }


        String fileName = Mpicture.getOriginalFilename();
        String filepath = "C:/Users/Administrator/IdeaProjects/salefood/src/main/resources/static/images/";
        File dest = new File(filepath + fileName);
        String picture;
        try {
            Mpicture.transferTo(dest);
            picture = filepath + fileName;
            //     logger.info("上传成功");
        } catch (IOException e) {
            //     logger.error("上传失败");
            e.printStackTrace();
            return "上传失败";
        }
        Meat meat = new Meat(0, Meatid, Mname, Mstyle, Mprice, 10.0, picture);
        meat.setMpicture("/img/" + fileName);
        meatService.insertMeat(meat);
        return "RstManager_main";
    }


    //修改菜品的预处理，通过菜品编号Mid获取当前记录
    @RequestMapping(value = "meat_update", method = RequestMethod.GET)
    public String updateMeatPre(Integer Mid, Model model) {
        Meat meat = meatService.selectMeatById(Mid);
        model.addAttribute("meat", meat);
        return "update_Meat";//进入修改页面
    }

    //实际的修改
    @PostMapping(value = "/update_Meat")
    public String updateMeat(@RequestParam("Mid") Integer Mid,
                             @RequestParam("Meatid") Integer Meatid,
                             @RequestParam("Mname") String Mname,
                             @RequestParam("Mstyle") String Mstyle,
                             @RequestParam("Mprice") Double Mprice,
                             @RequestParam("Mscore") Double Mscore,
                             @RequestParam("Mpicture") MultipartFile Mpicture,
                             Map<String, String> map) {
        String msg;
        List<MeatB> re = meatRepository.findMeatBByMname(Mname);
        if (Mpicture.isEmpty()) {
            msg = "图片不能为空!";
            map.put("msg", msg);
            return "RstManager_main";
        } else if (re.size() != 0) {
            msg = "存在同名菜品！！";
            map.put("msg", msg);
            return "RstManager_main";
        }
        String fileName1 = Mpicture.getOriginalFilename();
        String filepath1 = "D:/MeatPictures/";
        File dest = new File(filepath1 + fileName1);
        String update_picture;
        try {
            Mpicture.transferTo(dest);
            update_picture = filepath1 + fileName1;
            //     logger.info("上传成功");
        } catch (IOException e) {
            //        logger.error("上传失败");
            e.printStackTrace();
            return "上传失败";
        }
        Meat meat = new Meat(Mid, Meatid, Mname, Mstyle, Mprice, Mscore, update_picture);
        meat.setMpicture("/img/" + fileName1);
        meatService.updateMeatById(meat);
        return "RstManager_main";
    }


    //Meat表，删除完成后 需要重新获取删除后的新的数据，再显示
    @RequestMapping("/meat_delete")
    public String deleteMeat(Integer Mid) {
        meatService.selectMeatById(Mid);
        return "RstManager_main";
    }
}
