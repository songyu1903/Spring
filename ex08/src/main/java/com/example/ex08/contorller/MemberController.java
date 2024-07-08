package com.example.ex08.contorller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/join")
    public String join(){
        return "member/join";
    }

    @GetMapping("/login")
    public String login(){
        return "member/login";
    }
}
