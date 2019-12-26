package com.javaweb_week.salefood.controller;

import com.javaweb_week.salefood.entity.Rstmanager;
import com.javaweb_week.salefood.service.RstmanagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ControllerB {


    @Autowired
    private RstmanagerService rstmanagerService;

    @RequestMapping("/rstmanagerLogin")//action="rstmanagerLogin"
    public String rstmanagerLogin(String rmusername, String rmpassword, Map<String,Rstmanager> map){// name="rmusername" name="rmpassword"
        Rstmanager rstmanager = rstmanagerService.rstmanagerLogin(rmusername,rmpassword);
        if(rstmanager != null){//说明输入的账号和密码是正确
            map.put("rstmanager",rstmanager);
            return "Rstmanager_main";
        }else{
            return "rstmanagerLogin";
        }
    }
}
