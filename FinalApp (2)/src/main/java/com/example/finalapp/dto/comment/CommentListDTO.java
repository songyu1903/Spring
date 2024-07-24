package com.example.finalapp.dto.comment;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class CommentListDTO {
    private Long commentId;
    private String content;
    private String createDate;
    private String modifiedDate;
    private Long boardId;
    private Long memberId;
    private String loginId;
}
