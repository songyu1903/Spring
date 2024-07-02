package com.example.ex07.controller;

import com.example.ex07.dto.BoardDTO;
import com.example.ex07.mapper.BoardMapper;
import com.example.ex07.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Model model){
        List<BoardDTO> boardList = boardService.findBoardList();
        model.addAttribute("boardList", boardList);

        return "board/list";
    }
    @GetMapping("/detail")
    public String detail(Long boardId, Model model){
        BoardDTO boardDTO = boardService.findBoardDetail(boardId);
        model.addAttribute("boardDTO", boardDTO);
        return "board/detail";
    }
}

