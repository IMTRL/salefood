package com.javaweb_week.salefood.controller;

import com.javaweb_week.salefood.entity.Count;
import com.javaweb_week.salefood.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller

public class ControllerC {
    //countController
    @Autowired
    private CountService CountService;
    @RequestMapping("/searchcount")
    public String searchCount(Map<String,Object> map,String mname){
        List<Count> Counts = CountService.getCountByName(mname);
        map.put("mname",mname);
        map.put("Counts",Counts);
        return "count_name";
    }


}
