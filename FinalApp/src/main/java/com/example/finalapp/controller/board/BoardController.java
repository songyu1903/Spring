package com.example.finalapp.controller.board;

import com.example.finalapp.dto.board.BoardWriteDTO;
import com.example.finalapp.service.board.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("list")
    public String list() {
        return "board/list";
    }
    @GetMapping("write")
    public String write(HttpSession session) {
        Long memberId = (Long)session.getAttribute("memberId");

        if(memberId == null) {
            return "redirect:/member/login";
        }

        return "board/write";
    }
    @PostMapping("write")
    public String write(@SessionAttribute("memberId") Long memberId, BoardWriteDTO boardWriteDTO){

        boardWriteDTO.setMemberId(memberId);
        log.info("boardWriteDTO: {}", boardWriteDTO);

        boardService.addBoard(boardWriteDTO);

        return "board/list";
    }

    @GetMapping("detail")
    public String detail() {
        return "board/detail";
    }
}
