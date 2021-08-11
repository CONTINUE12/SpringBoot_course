package com.example.demo.controller;

import com.example.demo.bean.Account;
import com.example.demo.bean.City;
import com.example.demo.bean.User;
import com.example.demo.service.AccountService;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    AccountService accountService;

    @Autowired
    CityService cityService;

    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id){
        return cityService.getById(id);
    }



    @ResponseBody
    @GetMapping("/acct")
    public Account getById(@RequestParam("id") Integer id){
        return accountService.getAcctById(id);
    }


    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping(value = "/login")
    public String main(User user, HttpSession session, Model model){
        if(StringUtils.hasLength(user.getUsername()) && "123456".equals(user.getPassword())){
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser",user);
            //登录成功重定向到main.html;  重定向防止表单重复提交
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            //回到登录页面
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        //int a = 10/0; //测试5xx页面
        //是否登录。  拦截器，过滤器
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null){
            return "main";
        }else {
            //回到登录页面
            model.addAttribute("msg","请重新登录");
            return "login";
        }
    }


}
