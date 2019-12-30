package com.javaweb_week.salefood.controller;

import com.javaweb_week.salefood.entity.Orders;
import com.javaweb_week.salefood.entity.Student;
import com.javaweb_week.salefood.repository.OrdersRepository;
import com.javaweb_week.salefood.repository.StudentRepository;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class ControllerA {

    @Autowired
    private Student student;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private OrdersRepository ordersRepository;

    @RequestMapping("/student-login")
    public String studentLogin() {
        return "Student_login";
    }

    @RequestMapping("/student-logining")
    public String studentLogining(@RequestParam("sno") int sno,
                                  @RequestParam("userpassword") String userpassword,
                                  Map<String, String> map,
                                  HttpServletRequest request) {
        List<Student>result=studentRepository.findStudentBySidAndSpassword(sno,userpassword);
        if (result.size()!=0) {
            request.getSession().setAttribute("userId",result.get(0).getSid());
            return "Student_function";
        } else {
            map.put("msg", "用户名或密码错误");
            return "Student_login";
        }
    }

    @RequestMapping("/student-regist")
    public String studentRegist() {
        return "Student_regist";
    }

    @RequestMapping("/student-registing")
    public String studentRegisting(@RequestParam("name") String name,
                                   @RequestParam("number") Integer number,
                                   @RequestParam("password") String password) {
        if (!StringUtils.isNullOrEmpty(name) && !StringUtils.isNullOrEmpty(password)) {
            student=new Student(number,name,password,0.0);
            studentRepository.saveAndFlush(student);
        }

        return "Student_regist";
    }

    @RequestMapping("/student-info")
    public String studentInfo(Map<String, Student> map,
                              @RequestParam("userId") Integer id) {
        List<Student>result=studentRepository.findStudentBySid(id);
        map.put("sinfo",result.get(0));
        return "Student_info";
    }

    @RequestMapping("/student-buyfood")
    public String studentBuyfood(@RequestParam("userId")int id) {

        return "Student_buyfood";
    }

    @RequestMapping("/student-orderlist")
    public String studentOrderlist(@RequestParam("userId")int id,
                                   Map<String,List<Orders>>map) {
        List<Orders>result=ordersRepository.findOrdersBySid(id);
        map.put("orders",result);
        return "Student_orderlist";
    }

    @RequestMapping("/student-password-update")
    public String studentPasswordupdate(@RequestParam("userId") Integer id,
                                        Map<String, Student> map) {
        map.put("sinfo",studentRepository.findStudentBySid(id).get(0));
        return "Student_password_update";
    }
    @RequestMapping("/student-password-updateing")
    public String studentPasswordupdateing(@RequestParam("newPA") String password,
                                           @RequestParam("id") int id,
                                           Map<String, Student> map) {
       studentRepository.updateStudentSpassword(password,id);
        List<Student>result=studentRepository.findStudentBySid(id);
        map.put("sinfo",result.get(0));
        return "Student_info";
    }

    @RequestMapping("/student-buycar")
    public String studentbuycar() {
        return "Student_buycar";
    }
}
