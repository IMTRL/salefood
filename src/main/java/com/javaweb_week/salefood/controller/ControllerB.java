package com.javaweb_week.salefood.controller;

import com.javaweb_week.salefood.entity.Foods;
import com.javaweb_week.salefood.entity.Meat;
import com.javaweb_week.salefood.entity.Rstmanager;
import com.javaweb_week.salefood.service.FoodsService;
import com.javaweb_week.salefood.service.MeatService;
import com.javaweb_week.salefood.service.RstmanagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
