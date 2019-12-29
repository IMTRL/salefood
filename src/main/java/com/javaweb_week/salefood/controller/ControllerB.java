package com.javaweb_week.salefood.controller;

import com.javaweb_week.salefood.entity.Foods;
import com.javaweb_week.salefood.entity.Meat;
import com.javaweb_week.salefood.entity.Rstmanager;
import com.javaweb_week.salefood.service.FoodsService;
import com.javaweb_week.salefood.service.MeatService;
import com.javaweb_week.salefood.service.RstmanagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;
import java.util.Map;

@Controller
public class ControllerB {


    @Autowired
    private RstmanagerService rstmanagerService;
    @Autowired
    private FoodsService foodsService;
    @Autowired
    private MeatService meatService;

    //localhost：8080/RstManager_Login
    //食堂管理员登录
    @RequestMapping("/RstManager_Login")//action="RstManager_Login"
    public String RstManagerLogin(String rmusername, String rmpassword, Map<String,Rstmanager> map){
        Rstmanager rstManager = rstmanagerService.RstManagerLogin(rmusername,rmpassword);
        if(rstManager != null){//判断输入的账号和密码是正确
            map.put("rstManager",rstManager);
            return "RstManager_main";
        }else{
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
    public String getFoods(Map<String,Object> map){
        List<Foods> foods = foodsService.selectFoods();
        map.put("foods",foods);
        return "Foods";//Foods.html
    }
    //进入添加菜组页面（菜组表）
    @GetMapping(value="/add_Foods")
    public String addFoods(){
        return "add_Foods";
    }
    //实际完成添加业务
    @PostMapping(value="/add_Foods")
    public String addFoods(Foods foods){
        foodsService.insertFoods(foods);
        return "RstManager_main";
    }


    //修改的预处理，通过菜组编号Fid获取当前记录
    @RequestMapping(value="f_update",method = RequestMethod.GET)
    public String updateFoodsPre(int Fid,Model model){
        Foods foods = foodsService.selectFoodsById(Fid);
        model.addAttribute("foods",foods);
        return "update_Foods";//进入修改页面
    }
    //实际的修改
    @RequestMapping(value="/update_Foods",method = RequestMethod.POST)
    public String updateFoods(Foods foods){
        foodsService.updateFoodsById(foods);
        return "RstManager_main";
    }

    //Foods表，删除完成后 需要重新获取删除后的新的数据，再显示
    @RequestMapping("/f_delete")
    public String deleteFoods(int Fid){
        foodsService.deleteFoodsById(Fid);
        return "RstManager_main";
    }

    //显示对应菜组所有的菜品
    @RequestMapping("/f_meat")
    public String getMeat(Integer Fid,Map<String,Object> map){
        List<Meat> meat = meatService.selectMeat(Fid);
        map.put("meat",meat);
        return "Meat";//Meat.html
    }

    //进入添加菜品页面（菜品表Meat）
    @GetMapping(value="/add_Meat")
    public String addMeat(){
        return "add_Meat";
    }
    //实际完成添加业务
    @PostMapping(value="/add_Meat")
    public String addMeat(Meat meat){
        meatService.insertMeat(meat);
        return "RstManager_main";
    }


    //修改的预处理，通过菜品编号Mid获取当前记录
    @RequestMapping(value="meat_update",method = RequestMethod.GET)
    public String updateMeatPre(Integer Mid,Model model){
        Meat meat = meatService.selectMeatById(Mid);
        model.addAttribute("meat",meat);
        return "update_Meat";//进入修改页面
    }
    //实际的修改
    @RequestMapping(value="/update_Meat",method = RequestMethod.POST)
    public String updateMeat(Meat meat){
        meatService.updateMeatById(meat);
        return "RstManager_main";
    }

    //Meat表，删除完成后 需要重新获取删除后的新的数据，再显示
    @RequestMapping("/meat_delete")
    public String deleteMeat(Integer Mid){
        meatService.deleteMeatById(Mid);
        return "RstManager_main";
    }
}
