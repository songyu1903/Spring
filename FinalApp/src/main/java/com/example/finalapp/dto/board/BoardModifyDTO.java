package com.example.finalapp.dto.board;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor @Builder
public class BoardModifyDTO {
    private Long boardId;
    private String title;
    private String content;
}
