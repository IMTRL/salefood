package com.javaweb_week.salefood.controller;

import com.javaweb_week.salefood.entity.Allfoods;
import com.javaweb_week.salefood.entity.Foods;
import com.javaweb_week.salefood.entity.Rstmanager;
import com.javaweb_week.salefood.service.AllfoodsService;
import com.javaweb_week.salefood.service.FoodsService;
import com.javaweb_week.salefood.service.MeatService;
import com.javaweb_week.salefood.service.RstmanagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class ControllerB {


    @Autowired
    private RstmanagerService rstmanagerService;
    @Autowired
    private AllfoodsService allfoodsService;
    @Autowired
    private FoodsService foodsService;
    @Autowired
    private MeatService meatService;

    //localhost：8080/RstManager_Login
    @RequestMapping("/RstManager_Login")//action="RstManager_Login"
    public String RstManagerLogin(String rmusername, String rmpassword, Map<String,Rstmanager> map){// name="rmusername" name="rmpassword"
        Rstmanager rstManager = rstmanagerService.RstManagerLogin(rmusername,rmpassword);
        if(rstManager != null){//说明输入的账号和密码是正确
            map.put("rstManager",rstManager);
            return "RstManager_main";
        }else{
            return "RstManager_Login";
        }
    }

    //显示所有的菜组
    @RequestMapping("/get_all_Foods")
    public String getAllFoods(Map<String,Object> map){
        List<Allfoods> allfoods = allfoodsService.selectAllfoods();
        map.put("allfoods",allfoods);
        return "Allfoods";//Allfoods.html
    }

    //进入添加菜组页面
    @RequestMapping(value="/add_Foods",method = RequestMethod.GET)
    public String add_Foods(){
        return "add_Foods";
    }
    //实际完成添加业务
    @RequestMapping(value="/add_Foods",method = RequestMethod.POST)
    public String add_Foods(Foods foods){
        foodsService.insertFoods(foods);
        return "RstManager_main";
    }

    //获取菜组信息
    @RequestMapping("/get_Foods")
    public String getFoods(Map<String,Object> map){
        List<Foods> foods = foodsService.selectFoods();
        map.put("foods",foods);
        return "Foods";//Foods.html
    }
}
