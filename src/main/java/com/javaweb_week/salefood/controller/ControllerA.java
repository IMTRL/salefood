package com.javaweb_week.salefood.controller;

import com.javaweb_week.salefood.entity.*;
import com.javaweb_week.salefood.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.*;

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
                                   Map<String, String> map) {
        List<Student> result = studentRepository.findStudentBySid(number);
        if (result.size() > 0) {
            String msg = "存在用户，注册失败!";
            map.put("msg", msg);
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
    public String studentBuyfood(Map<String, Object> map) {
        List<FoodsB> reslutA = foodsRepository.findAll();
        List<MeatB> reslutB = meatRepository.findAll();
        map.put("cz", reslutA);
        map.put("cp", reslutB);
        return "Student_buyfood";
    }


    @RequestMapping("/changeCZ")
    @ResponseBody
    public List<MeatB> changeCZ(@RequestParam("id") int id) {
        List<MeatB> result = meatRepository.findMeatBByMeatid(id);
        return result;
    }

    @RequestMapping("/incar")
    @ResponseBody
    public String incar(int mid, int number) {
        if (number == 0)
            return "添加失败，份数为0";
        MeatB meatb = meatRepository.findMeatBByMid(mid).get(0);
        Orderinfo orderinfo = new Orderinfo(meatb.getMid(), number, false);
        List<Orderinfo> oinfo = new LinkedList<>();
        if (sessionA.getAttribute("incar") == null) {
            sessionA.setAttribute("incar", oinfo);
            oinfo = (List<Orderinfo>) (sessionA.getAttribute("incar"));
            oinfo.add(orderinfo);
        } else {
            oinfo = (List<Orderinfo>) (sessionA.getAttribute("incar"));
            oinfo.add(orderinfo);
        }
        return "添加" + meatb.getMname() + number + "份成功！";
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
        Meat meat = new Meat();

        int id = (Integer) (sessionA.getAttribute("userId"));
        studentRepository.updateStudentSpassword(password, id);
        List<Student> result = studentRepository.findStudentBySid(id);
        map.put("sinfo", result.get(0));
        return "Student_info";
    }

    @RequestMapping("/student-buycar")
    public String studentbuycar(Map<String, Object> map) {
        List<Orderinfo> oinfo = new LinkedList<>();
        if (sessionA.getAttribute("incar") == null)
            sessionA.setAttribute("incar", oinfo);
        oinfo = (List<Orderinfo>) (sessionA.getAttribute("incar"));
        for (int i = 0; i < oinfo.size(); i++) {
            for (int j = i + 1; j < oinfo.size(); j++) {
                if (oinfo.get(i).getMid() == oinfo.get(j).getMid()) {
                    oinfo.get(i).setOnum(oinfo.get(i).getOnum() + oinfo.get(j).getOnum());
                    oinfo.remove(j);
                }
            }
        }
        List<MeatB> meatBS = new LinkedList<>();
        List<Integer> nums = new LinkedList<>();
        for (Orderinfo orderinfo : oinfo) {
            meatBS.add(meatRepository.findMeatBByMid(orderinfo.getMid()).get(0));
            nums.add(orderinfo.getOnum());
        }
        map.put("carinfo", meatBS);
        map.put("meatnum", nums);
        return "Student_buycar";
    }

    @RequestMapping("/buy")
    @ResponseBody
    public String buy() {
        List<Orderinfo> oinfo = new LinkedList<>();
        if (sessionA.getAttribute("incar") == null)
            return "未选菜，下单失败";
        oinfo = (List<Orderinfo>) (sessionA.getAttribute("incar"));
        if (oinfo.size() == 0)
            return "未选菜，下单失败";

        Calendar date = Calendar.getInstance();
        String s = date.getTimeInMillis() + "";
        int year = date.get(Calendar.YEAR);
        int month = (date.get(Calendar.MONTH) + 1);
        int day = date.get(Calendar.DAY_OF_MONTH);
        double money = 0;
        for (Orderinfo orderinfo : oinfo) {
            money += orderinfo.getOnum() * (meatRepository.findMeatBByMid(orderinfo.getMid()).get(0).getMprice());
            if (money > studentRepository.findStudentBySid((Integer) sessionA.getAttribute("userId"))
                    .get(0).getSbalance()) {
                return "余额不足！下单失败";
            }
        }
        int sid = (Integer) sessionA.getAttribute("userId");
        Orders orders = new Orders(s, sid, money, year, month, day);
        ordersRepository.saveAndFlush(orders);
        for (Orderinfo orderinfo : oinfo) {
            orderinfo.setOid(s);
            orderinfoRepository.saveAndFlush(orderinfo);
        }
        Student student=studentRepository.findStudentBySid(sid).get(0);
        student.setSbalance(student.getSbalance()-money);
        studentRepository.saveAndFlush(student);
        sessionA.removeAttribute("incar");

        return "下单成功！";


    }

    @RequestMapping("/gomain")
    public String gomain() {

        return "Student_function";
    }

    @RequestMapping("/outlogin")
    public String outlogin() {
        sessionA.invalidate();
        return "index";
    }

    @RequestMapping("/pingf")
    @ResponseBody
    public String pingf(String oid, double score) {
        Orderinfo orderinfo = orderinfoRepository.findOrderinfoByOid(oid).get(0);
        if (orderinfo.getOpingf())
            return "已经打分过了！";
        MeatB meatB = meatRepository.findMeatBByMid(orderinfo.getMid()).get(0);
        List<Orderinfo> result = orderinfoRepository.findOrderinfoByMid(meatB.getMid());
        double olds = meatB.getMscore();
        double news = (olds * result.size() + score) / (result.size() + 1);
        meatB.setMscore(news);
        meatRepository.saveAndFlush(meatB);
        orderinfo.setOpingf(true);
        orderinfoRepository.saveAndFlush(orderinfo);
        return "感谢打分";
    }

    @RequestMapping("/cleancar")
    public String clencar() {
        if (sessionA.getAttribute("incar") != null)
            sessionA.removeAttribute("incar");
        return "Student_buycar";
    }
}
