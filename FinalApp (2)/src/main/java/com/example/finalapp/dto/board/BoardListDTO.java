package com.example.finalapp.dto.board;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor @Builder
public class BoardListDTO {
    private Long boardId;
    private String title;
    private String loginId;
    private Long memberId;
    private Long fileId;
    private String name;
    private String uploadPath;
    private String uuid;
}











