package com.example.ex02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

    @GetMapping("/01")
    public String view01(){
        return "hello";
    }
    @GetMapping("/02")
    public String view02(){
        return "test/home";
    }
}
