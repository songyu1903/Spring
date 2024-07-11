package com.example.ex08.controller;

import com.example.ex08.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardApi {
    @GetMapping("/v1/board/{boardId}")
    public BoardDTO getBoard(@PathVariable Long boardId,
                             @RequestParam(defaultValue = "qna") String category){
        return new BoardDTO(boardId, category, "배고프다" , "저녁 추천 받아요");
    }

}
