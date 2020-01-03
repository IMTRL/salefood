package com.javaweb_week.salefood.controller;



import com.javaweb_week.salefood.entity.*;

import com.javaweb_week.salefood.repository.MeatRepository;
import com.javaweb_week.salefood.repository.OrderinfoRepository;
import com.javaweb_week.salefood.repository.OrdersRepository;
import com.javaweb_week.salefood.service.MeatCService;
import com.javaweb_week.salefood.service.OrdersBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller

public class ControllerC {
    @Autowired
    private MeatCService meatCService;

    @Autowired
    private OrderinfoRepository orderinfoRepository;

    @Autowired
    private OrdersBService ordersBService;
    @Autowired
    private MeatRepository meatRepository;
    @Autowired
    private OrdersRepository ordersRepository;



    @RequestMapping("/serachcount")
    public String getCount(Map<String,Object> map, String mname){
        MeatB meatC =meatRepository.findMeatBByMname(mname).get(0);
        Orderinfo orderinfoB=orderinfoRepository.findOrderinfoByMid(meatC.getMid()).get(0);
        OrdersB ordersB=ordersBService.selectOrdersBById(orderinfoB.getOid());
        map.put("mname",mname);
        map.put("meatC",meatC);
        map.put("orderinfoB",orderinfoB);
        map.put("ordersB",ordersB);
        return "count_name";
    }
    @RequestMapping("/serachdate")
    public String getcount(Map<String,Object>map, Integer oyear,Integer omonth,Integer oday){
        List<Orders> orders=ordersRepository.findOrdersByOyearAndOmonthAndOday(oyear,omonth,oday);
        String[] meatname=new String[orders.size()];
        for (int i=0;i<orders.size();i++) {
            meatname[i]=meatCService.selectMeatCById(orderinfoRepository.findOrderinfoByOid(orders.get(i).getOid()).get(0).getMid()).getMname();
        }
        map.put("meatname",meatname);
        map.put("oday",oday);
        map.put("omonth",omonth);
        map.put("oyear",oyear);
        return "count_date";
}

    @RequestMapping("/Count")
    public String Count(){
        return "count";
    }
    @RequestMapping("/to_count")
    public String to_count(){
        return "count_nameA";
    }
    @RequestMapping("/to_data")
    public String to_data(){ return "count_dataA";}



}
