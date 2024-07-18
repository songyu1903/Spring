package com.example.finalapp.dto.board;

import lombok.*;

import javax.swing.text.html.parser.DTD;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor @Builder
public class BoardWriteDTO {
    private Long boardId;
    private String title;
    private String content;
    private Long memberId;
}
