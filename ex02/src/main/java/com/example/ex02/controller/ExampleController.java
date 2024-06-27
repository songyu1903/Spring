package com.example.ex02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 이 클래스도 Bean으로 등록을해야 스프링에서 관리를 해준다.
// 이 클래스는 controller 라는 목적이 있으므로 그에 맞게 등록을 해줘야한다.
@Controller
public class ExampleController {

    @RequestMapping("/01")
    public void ex01(){
        System.out.println("ex01() 실행!!!");
    }

    @RequestMapping("/02")
    public void ex02(){
        System.out.println("ex02() 실행!!!");
    }
}
