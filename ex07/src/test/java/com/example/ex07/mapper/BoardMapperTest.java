package com.example.ex07.mapper;

import com.example.ex07.dto.BoardDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;

    @Test
    void insertBoard() {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle("test title");
        boardDTO.setContent("test content");

        boardMapper.insertBoard(boardDTO);
    }

    @Test
    void selectBoard() {
        BoardDTO foundBoard = boardMapper.selectBoard(1L);
        System.out.println("foundBoard = " + foundBoard);
    }

    @Test
    void updateViewCnt() {
        boardMapper.updateViewCnt(1L);
    }

    @Test
    void selectAll() {
        List<BoardDTO> boardDTOList = boardMapper.selectAll();
    }


}