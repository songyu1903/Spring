package com.example.ex03.dto;

import lombok.Data;

@Data
public class TodoDTO {
    private String content;
    private String writer;
    private boolean finished;
    private String todoDate;
}
