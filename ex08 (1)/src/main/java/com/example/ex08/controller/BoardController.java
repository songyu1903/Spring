package com.example.ex08.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    @GetMapping("/list")
    public String list(){
        return "board/list";
    }

    @GetMapping("/detail")
    public String detail(){
        return "board/detail";
    }

    @GetMapping("/write")
    public String write(){
        return "board/write";
    }
}











