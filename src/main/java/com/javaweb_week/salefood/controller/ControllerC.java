package com.javaweb_week.salefood.controller;

import com.javaweb_week.salefood.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller

public class ControllerC {
    //countController
    @Autowired private CountService CountService;
}
