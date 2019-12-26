package com.javaweb_week.salefood;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.javaweb_week.salefood.dao")
public class SalefoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalefoodApplication.class, args);
    }

}
