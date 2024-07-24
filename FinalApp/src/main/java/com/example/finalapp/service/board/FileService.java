package com.example.finalapp.service.board;

import com.example.finalapp.dto.board.file.FileListDTO;
import com.example.finalapp.dto.board.file.FileWriteDTO;
import com.example.finalapp.mapper.board.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileMapper fileMapper;

    public void addFile(FileWriteDTO fileWriteDTO){
        fileMapper.insertFile(fileWriteDTO);
    }

    public List<FileListDTO> findList(Long boardId){
        return fileMapper.selectFileList(boardId);
    }

    public void removeFile(Long boardId){
        fileMapper.deleteFile(boardId);
    }
}
