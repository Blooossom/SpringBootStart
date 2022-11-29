package com.example.test1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home(){
        return "home";
    }
    /*
    기존에 static에 index로 간다고 함
    매핑된 것이 있으면 html이 호출되고 끝남(즉 static까지 안감)
     */

}
