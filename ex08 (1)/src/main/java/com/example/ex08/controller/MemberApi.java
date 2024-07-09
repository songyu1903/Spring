package com.example.ex08.controller;

import com.example.ex08.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

// @RestController 는 @Controller와 @ResponseBody을 합쳐놓은 어노테이션이다.
// 즉, 이 클래스 내부에 만드는 메서드들은 전부 데이터를 반환하게 된다.
@RestController
@RequiredArgsConstructor
public class MemberApi {
    private final MemberService memberService;

    @GetMapping("/v1/member/test")
    public String test(){
        return "test합니다!";
    }

    @GetMapping("/v1/members/login-id")
    public int checkLoginId(String loginId){
        return memberService.checkLoginId(loginId);
    }




}








