package com.javaweb_week.salefood.controller;

import com.javaweb_week.salefood.entity.*;
import com.javaweb_week.salefood.repository.*;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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
    @Autowired
    private OrderinfoRepository orderinfoRepository;
    @Autowired
    private MeatRepository meatRepository;
    @Autowired
    private FoodsRepository foodsRepository;

    HttpSession sessionA;

    @RequestMapping("/student-login")
    public String studentLogin() {
        return "Student_login";
    }

    @RequestMapping("/student-logining")
    public String studentLogining(@RequestParam("sno") int sno,
                                  @RequestParam("userpassword") String userpassword,
                                  Map<String, String> map,
                                  HttpServletRequest request) {
        List<Student> result = studentRepository.findStudentBySidAndSpassword(sno, userpassword);
        if (result.size() != 0) {
            sessionA = request.getSession();
            sessionA.setAttribute("userId", result.get(0).getSid());
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
                                   @RequestParam("password") String password,
                                   Map<String,String>map) {
            List<Student>result=studentRepository.findStudentBySid(number);
            if (result.size()>0){
                String msg="存在用户，注册失败!";
                map.put("msg",msg);
                return "Student_regist";
            }
            student = new Student(number, name, password, 0.0);
            studentRepository.saveAndFlush(student);

        return "Student_login";
    }

    @RequestMapping("/student-info")
    public String studentInfo(Map<String, Student> map) {


        int id = (Integer) (sessionA.getAttribute("userId"));
        List<Student> result = studentRepository.findStudentBySid(id);
        map.put("sinfo", result.get(0));
        return "Student_info";
    }

    @RequestMapping("/student-buyfood")
    public String studentBuyfood(Map<String,Object> map) {
        List<FoodsB>reslutA=foodsRepository.findAll();
        List<MeatB>reslutB=meatRepository.findAll();
        map.put("cz",reslutA);
        map.put("cp",reslutB);
        return "Student_buyfood";
    }
    @RequestMapping("/changeCZ")
    @ResponseBody
    public List<MeatB> changeCZ(@RequestParam("id")int id){
        List<MeatB>result=meatRepository.findMeatBByMeatid(id);
        return result;
    }

    @RequestMapping("/student-orderlist")
    public String studentOrderlist(Map<String, Object> map) {
        int id = (Integer) (sessionA.getAttribute("userId"));
        List<Orders> resultA = ordersRepository.findOrdersBySid(id);
        List<Map<String, Integer>> resultB = new LinkedList<>();
        for (Orders orders : resultA) {
            Map<String, Integer> map1 = new LinkedHashMap<>();
            List<Orderinfo> resultb = orderinfoRepository.findOrderinfoByOid(orders.getOid());
            for (Orderinfo orderinfo : resultb) {
                String name = meatRepository.findMeatBByMid(orderinfo.getMid()).get(0).getMname();
                int num = orderinfo.getOnum();
                map1.put(name, num);
            }
            resultB.add(map1);
        }
        map.put("orders", resultA);
        map.put("oinfo", resultB);
        return "Student_orderlist";
    }

    @RequestMapping("/student-password-update")
    public String studentPasswordupdate(Map<String, Student> map) {
        int id = (Integer) (sessionA.getAttribute("userId"));
        map.put("sinfo", studentRepository.findStudentBySid(id).get(0));
        return "Student_password_update";
    }

    @RequestMapping("/student-password-updateing")
    public String studentPasswordupdateing(@RequestParam("newPA") String password,
                                           Map<String, Student> map) {
        Meat meat=new Meat();

        int id = (Integer) (sessionA.getAttribute("userId"));
        studentRepository.updateStudentSpassword(password, id);
        List<Student> result = studentRepository.findStudentBySid(id);
        map.put("sinfo", result.get(0));
        return "Student_info";
    }

    @RequestMapping("/student-buycar")
    public String studentbuycar() {
        return "Student_buycar";
    }
}
