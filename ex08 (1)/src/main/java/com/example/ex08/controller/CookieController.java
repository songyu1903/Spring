package com.example.ex08.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookieController {
    @GetMapping("/set-cookie")
    public String setCookie(HttpServletResponse resp){
        Cookie cookie = new Cookie("myCookie", "KIM");
//        60초 * 60초 = 1시간
        cookie.setMaxAge(60 * 60 * 24 * 7) ; // 쿠키의 유효기간을 설정 (초 단위)
//        ex) 로그인 페이지 = /member/login
        cookie.setPath("/"); // 쿠키의 유효 경로 설정, / 로 설정하면 모든 경로에서 사용가능

        resp.addCookie(cookie);
        return "쿠키 만듬";
    }
    @GetMapping("/get-cookie")
    public String getCookie(HttpServletRequest req){
        Cookie[] cookies = req.getCookies();
        String cookieValue = null;

        if(cookies != null){
            for(Cookie cookie : cookies){
                if("myCookie".equals(cookie.getName())){
                    cookieValue = cookie.getValue();
                }
            }
        }
        return "쿠키를 꺼냄 " + cookieValue;
    }
}
