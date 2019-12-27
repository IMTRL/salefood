package com.javaweb_week.salefood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerA {

    @RequestMapping("/student-mainpage")
    public String studentMainpage() {
        return "Student_function";
    }

    @RequestMapping("/student-login")
    public String studentLogin() {
        return "Student_login";
    }

    @RequestMapping("/student-regist")
    public String studentRegist() {
        return "Student_regist";
    }

    @RequestMapping("/student-registing")
    public String studentRegisting() {
        return "Student_regist";
    }

    @RequestMapping("/student-info")
    public String studentInfo() {
        return "Student_info";
    }

    @RequestMapping("/student-buyfood")
    public String studentBuyfood() {
        return "Student_buyfood";
    }

    @RequestMapping("/student-orderlist")
    public String studentOrderlist() {
        return "Student_orderlist";
    }

    @RequestMapping("/student-password-update")
    public String studentPasswordupdate() {
        return "Student_password_update";
    }

    @RequestMapping("/student-buycar")
    public String studentbuycar() {
        return "Student_buycar";
    }
}
