package com.example.ex08.dto;

import lombok.Data;

@Data
public class CommentListDTO {
    private Long commentId;
    private String content;
    private Long boardId;
    private Long memberId;
    private String loginId;
}
