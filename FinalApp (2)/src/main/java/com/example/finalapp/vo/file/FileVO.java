package com.example.finalapp.vo.file;

import lombok.Data;

@Data
public class FileVO {
    private Long fileId;
    private String name;
    private String uploadPath;
    private String uuid;
    private Long boardId;
}
