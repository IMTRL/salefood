package com.javaweb_week.salefood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerA {

    @RequestMapping("/student-login")
    public String studentLogin(){
        return "Student_login";
    }
}
