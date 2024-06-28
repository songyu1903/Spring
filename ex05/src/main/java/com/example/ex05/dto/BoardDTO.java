package com.example.ex05.dto;

import lombok.Data;

@Data
public class BoardDTO {
    private Long boardId;
    private String title;
    private String content;
    private String writer;
}
