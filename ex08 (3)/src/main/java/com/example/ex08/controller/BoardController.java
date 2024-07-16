package com.example.ex08.controller;

import com.example.ex08.dto.BoardDetailDTO;
import com.example.ex08.dto.BoardListDTO;
import com.example.ex08.dto.BoardWriteDTO;
import com.example.ex08.dto.SearchDTO;
import com.example.ex08.service.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String list(SearchDTO searchDTO, Model model){
        System.out.println("searchDTO = " + searchDTO);

//        List<BoardListDTO> list = boardService.findList();
        List<BoardListDTO> list = boardService.findSearchList(searchDTO);
        model.addAttribute("list", list);
        return "board/list";
    }

    @GetMapping("/detail")
    public String detail(Long boardId, Model model){
        BoardDetailDTO board = boardService.findBoard(boardId);
        model.addAttribute("board", board);
        return "board/detail";
    }

//    @GetMapping("/write")
//    public String write(HttpSession session){
//        Long memberId = (Long) session.getAttribute("memberId");
//        if(memberId == null){
//            return "redirect:/member/login";
//        }
//        return "board/write";
//    }

    @GetMapping("/write")
    public String write(@SessionAttribute(value = "memberId", required = false) Long memberId){

        if(memberId == null){
            return "redirect:/member/login";
        }
        return "board/write";
    }

    @PostMapping("/write")
    public String write(BoardWriteDTO boardWriteDTO,
                        @SessionAttribute("memberId") Long memberId){
        boardWriteDTO.setMemberId(memberId);
        boardService.addBoard(boardWriteDTO);
        return "redirect:/board/list";
    }
}











