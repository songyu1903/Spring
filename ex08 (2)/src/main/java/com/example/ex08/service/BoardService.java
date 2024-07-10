package com.example.ex08.service;

import com.example.ex08.dto.BoardDetailDTO;
import com.example.ex08.dto.BoardListDTO;
import com.example.ex08.dto.BoardWriteDTO;
import com.example.ex08.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public void addBoard(BoardWriteDTO boardWriteDTO){
        boardMapper.insertBoard(boardWriteDTO);
    }

    public BoardDetailDTO findBoard(Long boardId){
        return boardMapper.selectBoard(boardId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물 번호"));
    }

    public List<BoardListDTO> findList(){
        return boardMapper.selectList();
    }
}












