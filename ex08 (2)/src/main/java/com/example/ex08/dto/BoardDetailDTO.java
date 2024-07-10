package com.example.ex08.dto;

import lombok.Data;

@Data
public class BoardDetailDTO {
    private Long boardId;
    private String title;
    private String content;
    private Long memberId;
}
