package com.javaweb_week.salefood.controller;

import com.javaweb_week.salefood.entity.Student;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ControllerA {

    @Autowired
    private Student student = new Student();

    @RequestMapping("/student-login")
    public String studentLogin() {
        return "Student_login";
    }

    @RequestMapping("/student-logining")
    public String studentLogining(@RequestParam("username") String username,
                                  @RequestParam("userpassword") String userpassword,
                                  Map<String, String> map) {
        if (!StringUtils.isNullOrEmpty(username) && "123".equals(userpassword))
            return "Student_function";
        else {
            map.put("msg","用户名或密码错误");
            return "Student_login";
        }
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
    public String studentInfo(Map<String, Student> map) {

        student = new Student(1, "老谭", 100.00);
        map.put("sinfo", student);
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
