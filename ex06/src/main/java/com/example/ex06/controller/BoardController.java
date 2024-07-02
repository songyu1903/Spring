package com.example.ex06.controller;

import com.example.ex06.dto.BoardDTO;
import com.example.ex06.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardMapper boardMapper;

    @GetMapping("/register")
    public String register(){
        return "board/register";
    }

    @PostMapping("/register")
    public String register(BoardDTO boardDTO){
        System.out.println("boardDTO = " + boardDTO);
        boardMapper.insertBoard(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping("list")
    public String list(Model model){
        List<BoardDTO> boardDTOList = boardMapper.selectAll();
        model.addAttribute("boardDTOList", boardDTOList);
        return "board/list";
    }
    @GetMapping("/detail")
    public String detail(Long boardId, Model model){
        BoardDTO boardDTO = boardMapper.selectBoard(boardId);
        model.addAttribute("board", boardDTO);
        return "board/detail";
    }
    @GetMapping("/modify")
    public String modify(Long boardId, Model model){
        BoardDTO boardDTO = boardMapper.selectBoard(boardId);
        model.addAttribute("board", boardDTO);
        return "board/modify";
    }

    @PostMapping("/modify")
    public String modify(BoardDTO boardDTO,
                            RedirectAttributes redirectAttributes){
        boardMapper.updateBoard(boardDTO);
        redirectAttributes.addAttribute("boardId", boardDTO.getBoardId());
        return "redirect:/board/detail";
    }
}
