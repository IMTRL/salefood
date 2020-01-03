package com.javaweb_week.salefood.controller;


import com.javaweb_week.salefood.entity.*;
import com.javaweb_week.salefood.service.RstmanagerService;
import com.javaweb_week.salefood.service.StudentBService;
import com.javaweb_week.salefood.service.SysmanagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class SysManagerController {
    @Autowired
    private SysmanagerService sysmanagerService;

    @Autowired
    private RstmanagerService rstmanagerService;
    @Autowired
    private StudentBService studentBService;

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


//删除食堂管理员
    @RequestMapping("/rst_delete")
    public String deleteRstManager(Integer rmid) {
        rstmanagerService.deleteRstmanagerById(rmid);
        return "SysManager_main";
    }

    @RequestMapping("/get_Students")
    public String getStudent(Map<String, Object> map) {
        List<StudentB> student = studentBService.selectStudentB();
        map.put("student", student);
        return "StudentB";
    }

    //修改
    @RequestMapping(value = "student_update", method = RequestMethod.GET)
    public String updateStudentPre(Integer sid, Model model) {
        StudentB studentB = studentBService.selectStudentBById(sid);
        studentB.setSpassword("000000");
        studentBService.updateStudentBById(studentB);
        return "SysManager_main";//进入修改页面
    }


}
