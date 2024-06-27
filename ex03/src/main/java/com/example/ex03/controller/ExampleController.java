package com.example.ex03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ex")
public class ExampleController {
    @GetMapping("/01")
    public String ex01(){
        return "ex/01";
    }
    @PostMapping("/01")
    public void ex01 (@RequestParam("id") String userName){
        System.out.println("userName = " + userName);
    }
}
