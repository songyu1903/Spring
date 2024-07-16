package com.example.ex08.dto;

import lombok.Data;

@Data
public class CommentWriteDTO {
    private Long commentId;
    private String content;
    private Long boardId;
    private Long memberId;
}
