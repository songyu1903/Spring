package com.example.ex06.controller;

import com.example.ex06.dto.MemberDTO;
import com.example.ex06.mapper.MemberMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberMapper memberMapper;

    @GetMapping("/join")
    public String join(){
        return "member/join";
    }

    @PostMapping("/join")
    public String join(MemberDTO memberDTO){
        System.out.println("memberDTO = " + memberDTO);

        memberMapper.insertMember(memberDTO);

        return "redirect:/member/list";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<MemberDTO> memberList = memberMapper.selectAll();
        model.addAttribute("memberList", memberList);

        return "member/list";
    }

    @GetMapping("/detail")
    public String detail(Long memberId, Model model){
        MemberDTO foundMember = memberMapper.selectMember(memberId);
        model.addAttribute("foundMember", foundMember);

        return "member/detail";
    }

    @GetMapping("/modify")
    public String modify(Long memberId, Model model) {
        MemberDTO foundMember = memberMapper.selectMember(memberId);
        model.addAttribute("foundMember", foundMember);

        return "member/modify";
    }

    @PostMapping("/modify")
    public String modify(MemberDTO memberDTO,
                         RedirectAttributes redirectAttributes){
        memberMapper.updateMember(memberDTO);

        // 리디렉션을 할 때 데이터를 같이 전송하고 싶다면 일반적인 방법으로는 불가능하다.
        // 리디렉션 특성상 클라이언트에게 재요청할 url를 보내주게되는데
        // 이때 쿼리스트링을 같이 보내주면 개발자가 원하는 데이터를 보내는 처리가 가능하다.
        // 쿼리스트링을 개발자가 직접 문자열로 달아줄 수도 있지만
        // 문자열 연결처리에서 실수를 할 가능성이 높으므로 스프링에서 지원하는 특별한 객체를 사용한다.
        // 그 객체가 redirectAttributes 이다.
        // redirectAttributes의 addAttribute() 메서드를 사용하면 쿼리스트링을 만들 수 있다.
        // addAttribute("키", 값) -> ?키=값
        redirectAttributes.addAttribute("memberId", memberDTO.getMemberId());

        return "redirect:/member/detail";
    }

    @PostMapping("/remove")
    public String remove(Long memberId){
        memberMapper.deleteMember(memberId);
        return "redirect:/member/list";
    }


}













