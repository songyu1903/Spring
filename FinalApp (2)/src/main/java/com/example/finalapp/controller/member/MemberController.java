package com.example.finalapp.controller.member;

import com.example.finalapp.dto.member.MemberJoinDTO;
import com.example.finalapp.service.member.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    public String join(@ModelAttribute("memberJoinDTO") MemberJoinDTO memberJoinDTO) {
        return "member/join";
    }

    @PostMapping("/join")
    public String join(MemberJoinDTO memberJoinDTO, Model model) {
        try {
            memberService.addMember(memberJoinDTO);
        } catch (IllegalStateException e) {
            log.error(e.toString());
            model.addAttribute("memberJoinDTO", memberJoinDTO);
            model.addAttribute("duplicate", true);
//            log.info("POST /join : {}", e.toString());
//            log.info("안녕하세요!!!");
            return "member/join";
        }

        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @PostMapping("/login")
    public String login(String loginId, String password,
                        HttpSession session){
        Long memberId = null;

        try {
            memberId = memberService.findMemberId(loginId, password);
        } catch (IllegalArgumentException e) {
            log.error(e.toString());
            return "member/login";
        } catch (Exception e) {
            log.error(e.toString());
            return "member/login";
        }

        session.setAttribute("memberId", memberId);

        return "redirect:/board/list";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/board/list";
    }
}












