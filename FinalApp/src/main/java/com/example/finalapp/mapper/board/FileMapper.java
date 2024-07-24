package com.example.finalapp.mapper.board;

import com.example.finalapp.dto.board.file.FileListDTO;
import com.example.finalapp.dto.board.file.FileWriteDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    void insertFile(FileWriteDTO fileWriteDTO);

    List<FileListDTO> selectFileList(Long boardId);

    void deleteFile(Long boardId);
}
