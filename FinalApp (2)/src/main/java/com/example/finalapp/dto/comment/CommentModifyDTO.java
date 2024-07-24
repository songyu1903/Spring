package com.example.finalapp.dto.comment;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class CommentModifyDTO {
    private String content;
    private Long commentId;
}
