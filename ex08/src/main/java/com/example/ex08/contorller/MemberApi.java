package com.example.ex08.contorller;

import com.example.ex08.mapper.MemberMapper;
import com.example.ex08.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController 는 @Controller 와 @ResponseBody 를 합쳐놓은 어노테이션이다.
// 즉, 이 클래스 내부에 만드는 메서드들은 전부 데이터를 반환하게 된다.

@RestController
public class MemberApi {

    private final MemberMapper memberMapper;
    private final MemberService memberService;

    public MemberApi(MemberMapper memberMapper, MemberService memberService) {
        this.memberMapper = memberMapper;
        this.memberService = memberService;
    }

    @GetMapping("/v1/member/test")
    public String test(){
        return "test합니다!";
    }
    @GetMapping("v1/member/login-id")
    public int checkLoginId(String loginId){
        return memberService.checkLoginId(loginId);
    }
}
