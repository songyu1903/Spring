package com.example.finalapp.service.board;

import com.example.finalapp.dto.board.file.FileListDTO;
import com.example.finalapp.dto.board.file.FileWriteDTO;
import com.example.finalapp.mapper.board.FileMapper;
import com.example.finalapp.vo.file.FileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FileService {
    private final FileMapper fileMapper;

    public void addFile(FileWriteDTO fileWriteDTO) {
        fileMapper.insertFile(fileWriteDTO);
    }

    public List<FileListDTO> findList(Long boardId) {
        return fileMapper.selectList(boardId);
    }

    public void removeFile(Long boardId) {
        fileMapper.deleteFile(boardId);
    }

    public List<FileVO> findOldList(){
        return fileMapper.selectOldList();
    }
}















