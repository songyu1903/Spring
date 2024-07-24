package com.example.finalapp.dto.board.file;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor @Builder
public class FileListDTO {
    private Long fileId;
    private String name;
    private String uploadPath;
    private String uuid;
    private Long boardId;
}
