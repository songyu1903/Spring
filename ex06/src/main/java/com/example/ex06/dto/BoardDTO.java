package com.example.ex06.dto;

import lombok.Data;

@Data
public class BoardDTO {
    private Long boardId;
    private String title;
    private String content;
    private String writer;
}
