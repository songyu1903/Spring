package com.example.ex08.dto;

import lombok.Data;

@Data
public class BoardListDTO {
    private Long boardId;
    private String title;
    private String createdDate;
    private String loginId;
}
