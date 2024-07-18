package com.example.finalapp.dto.board;


import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor @Builder
public class BoardListDTO {
   private Long boardId;
   private Long memberId;
   private String loginId;
   private String title;
}
