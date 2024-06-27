package com.example.ex02.controller;

import com.example.ex02.dto.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 이 클래스도 Bean으로 등록을해야 스프링에서 관리를 해준다.
// 이 클래스는 controller 라는 목적이 있으므로 그에 맞게 등록을 해줘야한다.
@Controller
@RequestMapping("/ex")
public class ExampleController {

//  @RequestMapping 은 특정 url로 요청이 들어왔을 때 실행시킬 메서드를 연결시켜준다.
//  GET, POST 상관없이 연결된다.
    @RequestMapping("/01")
    public void ex01(){
        System.out.println("ex01() 실행!!!");
    }

//    @RequestMapping( value = "/02", method = {RequestMethod.GET, RequestMethod.POST})
//  @GetMapping 은 GET 방식으로 요청이 들어왔을 때 연결된 메서드를 실행시켜준다.
    @GetMapping("/02")
    public void ex02(){
        System.out.println("ex02() 실행!!!");
    }
    @GetMapping("/03")
    public void ex03(HttpServletRequest req){
        System.out.println("ex03() 메서드 실행!!!!");

        // 요청에 들어있는 데이터를 꺼낼 때 기존의 방식대로 Request를 활용할 수 있다.
        // 스프링에서는 HttpServletReques 같은 저순준의 기술을 직접 다루는걸
        // 선호하지 않는다. (사용방법이 불편하여 실수를 많이하기 때문)
        String name = req.getParameter("name");
        System.out.println(name);
    }

    @GetMapping("/04")
    public void ex04(String name){
        // 스프링 MVC 프레임워크는 요청에 담겨있는 데이터의 이름과 메서드 파라미터의
        // 이름이 동일하면 자동으로 데이터를 파라미터에 넣어준다
        System.out.println("ExampleController.ex04 @@@@");
        System.out.println("name = " + name);
    }
    @GetMapping("/05")
    public void ex05(int age){
        System.out.println("ExampleController.ex05");
        System.out.println("age = " + age);
    }

    @GetMapping("/06")
    public void ex06(String name, int age){
        System.out.println("ExampleController.ex06 *****");
        System.out.println("name = " + name + ", age = " + age);
    }
    @GetMapping("/07")
    public void ex07(MemberDTO memberDTO){
        // 여러 데이터를 넘겨 받을때 DTO클래스를 생성하여 한 번에 받을 수 있다.
        // 요청에 담긴 데이터의 이름과 DTO클래스의 필드 이름이 일치하면
        // 자동으로 데이터를 넣어준다.
        System.out.println("ExampleController.ex07 $$$$");
        System.out.println("memberDTO = " + memberDTO);
    }
}
