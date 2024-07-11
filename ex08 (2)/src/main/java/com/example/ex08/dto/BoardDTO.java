package com.example.ex08.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardDTO {
    private Long boardId;
    private String category;
    private String content;
    private String title;
}
