package com.example.finalapp.dto.board;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor @Builder
public class BoardDetailDTO {
    private Long boardId;
    private String title;
    private String content;
    private Long memberId;
    private String createDate;
    private String modifiedDate;
    private String loginId;

}
