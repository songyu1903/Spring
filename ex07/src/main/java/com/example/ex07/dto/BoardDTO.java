package com.example.ex07.dto;

import lombok.Data;

@Data
public class BoardDTO {
    private Long boardId;
    private String title;
    private String content;
    private int viewCnt;
}
