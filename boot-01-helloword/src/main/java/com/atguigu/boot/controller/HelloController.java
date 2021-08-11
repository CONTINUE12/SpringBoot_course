package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
@Slf4j
@RestController //代替上面两个注解
public class HelloController {

    @RequestMapping("/hello")
    public String handle01(){
        log.info("请求进来了....");
        return "Hello,Spring Boot 2!";
    }

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car(){
        return car;
    }

}
