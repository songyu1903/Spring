package com.example.ex08.mapper;

import com.example.ex08.dto.BoardDetailDTO;
import com.example.ex08.dto.BoardListDTO;
import com.example.ex08.dto.BoardWriteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {
    @Autowired BoardMapper boardMapper;

    @Test
    void insertBoard() {
        BoardWriteDTO boardWriteDTO = new BoardWriteDTO();
        boardWriteDTO.setTitle("test title");
        boardWriteDTO.setContent("test content");
        boardWriteDTO.setMemberId(1L);

        boardMapper.insertBoard(boardWriteDTO);
    }

    @Test
    void selectBoard() {
        BoardDetailDTO boardDetailDTO = boardMapper.selectBoard(1L).get();

        System.out.println("boardDetailDTO = " + boardDetailDTO);
    }

    @Test
    void selectList() {
        List<BoardListDTO> dtoList = boardMapper.selectList();

        System.out.println("dtoList = " + dtoList);
    }
}









