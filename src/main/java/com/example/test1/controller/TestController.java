package com.example.test1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("hello")
    public String Test(Model model){
        model.addAttribute("data","hello!");
        return "hello";

    }
}