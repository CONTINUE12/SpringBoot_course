package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    //不同注解的作用
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("username") String name, //获取请求路径
                                     @PathVariable("id") Integer id,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent, //获取请求头
                                     @RequestHeader Map<String,String> header
//                                     @RequestParam("age") Integer age, //获取请求参数
//                                     @RequestParam("inters") List<String> inters,
//                                     @RequestParam Map<String,String> params,
//                                     @CookieValue("_ga") String _ga, //获取cookie值
//                                     @CookieValue("_ga") Cookie cookie
    ){

        Map<String,Object> map = new HashMap<>();
        map.put("username",name);
        map.put("id",id);
        map.put("pv",pv);
        map.put("userAgent",userAgent);
        map.put("headers",header);
//        map.put("age",age);
//        map.put("inters",inters);
//        map.put("params",params);
//        map.put("_ga",_ga);
//        System.out.println(cookie.getName()+"===>"+cookie.getValue());
        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content //获取请求体[POST]
    ){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }

    //1、语法： 请求路径：/cars/sell;low=34;brand=byd,audi,yd
    //2、SpringBoot默认是禁用了矩阵变量的功能
    //      手动开启：原理。对于路径的处理。UrlPathHelper进行解析。
    //              removeSemicolonContent（移除分号内容）支持矩阵变量的
    //3、矩阵变量必须有url路径变量才能被解析
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low, //请求矩阵变量
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();

        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }

}
