package com.example.ex08.contorller;

import com.example.ex08.dto.MemberDTO;
import com.example.ex08.exception.DuplicatedLoginIdException;
import com.example.ex08.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    public String join(){
        return "member/join";
    }

    @GetMapping("/login")
    public String login(){
        return "member/login";
    }
    @PostMapping("/join")
    public String join(MemberDTO memberDTO){
        try {
            memberService.addMember(memberDTO);
        } catch (DuplicatedLoginIdException e) {
            e.printStackTrace();
            return "redirect:/member/join";
        }
        return "redirect:/member/login";
    }
    @PostMapping("/login")
    public String login(String loginId, String password){
        Long memberId = memberService.findMemberId(loginId, password);
        System.out.println("memberId = " + memberId);
        return null;
    }
}
