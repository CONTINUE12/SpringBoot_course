package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/basic_table.html")
    public String basic_table(){
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table.html")
    public String dynamic_table(Model model){

        List<User> list = userService.list();
        model.addAttribute("users",list);

        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table.html")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table.html")
    public String editable_table(){
        return "table/editable_table";
    }

}
