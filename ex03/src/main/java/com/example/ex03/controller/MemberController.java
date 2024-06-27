package com.example.ex03.controller;

import com.example.ex03.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/join")
    public String MemberJoin(){
        return "member/join";
    }
    @PostMapping("/join")
    public void MemberJoin(MemberDTO memberDTO){
        System.out.println("memberDTO = " + memberDTO);
    }
}
