package com.javaweb_week.salefood.controller;


import com.javaweb_week.salefood.entity.Rstmanager;
import com.javaweb_week.salefood.entity.Sysmanager;
import com.javaweb_week.salefood.service.RstmanagerService;
import com.javaweb_week.salefood.service.SysmanagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class SysManagerController {
    @Autowired
    private SysmanagerService sysmanagerService;

    @Autowired
    private RstmanagerService rstmanagerService;

    //localhost:8080/SysManager_Login
    @RequestMapping("/SysManager_Login")
    public String SysManagerLogin(String smusername, String smpassword, Map<String, Sysmanager> map) {
        Sysmanager sysmanager = sysmanagerService.SysManagerLogin(smusername, smpassword);
        if (sysmanager != null) {//判断输入的账号和密码是正确
            map.put("sysmanager", sysmanager);
            return "SysManager_main";
        } else {
            return "SysManager_Login";
        }
    }
    @RequestMapping("/get_RstManagers")
    public String getRstManager(Map<String, Object> map) {
        List<Rstmanager> rstmanager = rstmanagerService.selectRstmanager();
        map.put("rstmanager", rstmanager);
        return "RstManager";
    }

    //进入添加页面
    @GetMapping(value = "/add_RstManager")
    public String addRstManager() {
        return "add_RstManager";
    }
    //实际完成添加业务
    @PostMapping(value = "/add_RstManager")
    public String addRstManager(Rstmanager rstmanager) {
        rstmanagerService.insertRstmanager(rstmanager);
        return "SysManager_main";
    }



    @RequestMapping("/rst_delete")
    public String deleteRstManager(Integer rmid) {
        rstmanagerService.deleteRstmanagerById(rmid);
        return "SysManager_main";
    }
}
