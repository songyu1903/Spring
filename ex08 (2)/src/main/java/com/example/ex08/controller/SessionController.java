package com.example.ex08.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
public class SessionController {

    @GetMapping("/v1/set-session")
    public String setSession1(HttpServletRequest req){
        HttpSession session = req.getSession();
        session.setAttribute("name", "김철수");

        return "세션 설정 완료!!!";
    }

    @GetMapping("/v1/get-session")
    public String getSession1(HttpServletRequest req){
        HttpSession session = req.getSession();
        String name = (String)session.getAttribute("name");
        return "세션 가져오기!!" + name;
    }

    @GetMapping("/v2/set-session")
    public String setSession2(HttpSession session){
        session.setAttribute("age", 11);

        return "세션 설정 완료2";
    }

    @GetMapping("/v2/get-session")
    public String getSession2(HttpSession session){
        Integer age = (Integer)session.getAttribute("age");
        return "세션 가져오기 : " + age;
    }

    @GetMapping("/v3/get-session")
    public String getSession3(@SessionAttribute("age") Integer age){
        return "세션 가져오기 : " + age;
    }

    @GetMapping("/v1/remove-session")
    public String removeSession(HttpSession session){
//        removeAttribute() : 세션에 저장된 특정 값을 삭제한다.
        session.removeAttribute("age");
//        invalidate() : 세션 종료, 세션의 모든 값이 사라진다.
        session.invalidate();

        return "세션 데이터 삭제";
    }

}
