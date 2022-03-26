package com.arsud.Java_spring_login_example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/index")
    public String toIndex(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
