package com.example.test1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping("hello")
    public String Test(Model model){
        model.addAttribute("data","hello!");
        return "hello";

    }


    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }


    @GetMapping("hello-spring")
    @ResponseBody
    public String helloSpring(@RequestParam("name") String name){
        return "hello"+name;
    }//데이터를 그대로 내려줌


    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloapi(@RequestParam("name")String name){
        Hello hello  = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
