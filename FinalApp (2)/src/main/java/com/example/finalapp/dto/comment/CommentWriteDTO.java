package com.example.finalapp.dto.comment;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class CommentWriteDTO {
    private Long commentId;
    private String content;
    private Long memberId;
    private Long boardId;
}
