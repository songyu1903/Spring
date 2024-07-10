package com.example.ex08.controller;

import com.example.ex08.dto.MemberDTO;
import com.example.ex08.exception.DuplicatedLoginIdException;
import com.example.ex08.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    public String join(){
        return "member/join";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest req, Model model){
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for(Cookie cookie : cookies) {
                if("loginId".equals(cookie.getName())){
                    model.addAttribute("loginId", cookie.getValue());
                }
            }
        }

        return "member/login";
    }

    @PostMapping("/join")
    public String join(MemberDTO memberDTO) {
        try {
            memberService.addMember(memberDTO);
        } catch (DuplicatedLoginIdException e) {
            e.printStackTrace();
            return "redirect:/member/join";
        }
        return "redirect:/member/login";
    }

    @PostMapping("/login")
    public String login(String loginId, String password, boolean rememberMe,
                        HttpServletResponse resp,
                        HttpSession session) {
        Long memberId = memberService.findMemberId(loginId, password);
        System.out.println("memberId = " + memberId);

        System.out.println("rememberMe = " + rememberMe);

        if(rememberMe && memberId != null) {
            Cookie cookie = new Cookie("loginId", loginId);
            cookie.setMaxAge(60 * 60 * 24 * 7);
            cookie.setPath("/");
            resp.addCookie(cookie);
        }

        session.setAttribute("memberId", memberId);

        return "redirect:/board/list";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/board/list";
    }


//  @ResponseBody는 메서드가 반환하는 데이터를 응답 본문에 담아 보낸다.
//  일반 컨트롤러의 메서드는 반환하는 문자열이 템플릿(html)파일의 위치를 나타내며
//    스프링 MVC는 해당 파일을 완성시켜 완성된 HTML문서를 응답 본문에 담아 보내는 것이다.
//    그런데 HTML 문서를 통째로 보내는것이 아니라 클라이언트 쪽에서 필요한 데이터만 보내고 싶다면
//    @ResponseBody 어노테이션을 활용하면 된다.
    @ResponseBody
    @GetMapping("/data")
    public String data(){
        return "중복입니다.";
    }
}












