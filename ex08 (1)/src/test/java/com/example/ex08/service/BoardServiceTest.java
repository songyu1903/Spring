package com.example.ex08.service;

import com.example.ex08.dto.BoardDetailDTO;
import com.example.ex08.dto.BoardListDTO;
import com.example.ex08.dto.BoardWriteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    BoardService boardService;

    @Test
    void addBoard() {
//        1. 준비
        BoardWriteDTO boardWriteDTO = new BoardWriteDTO();
        boardWriteDTO.setTitle("test title2");
        boardWriteDTO.setContent("test content2");
        boardWriteDTO.setMemberId(1L);

//        2. 실행
        boardService.addBoard(boardWriteDTO);

//        3. 검증

    }

    @Test
    void findBoard() {
        BoardDetailDTO foundBoard = boardService.findBoard(2L);

        System.out.println("foundBoard = " + foundBoard);
    }

    @Test
    void findList() {
        List<BoardListDTO> list = boardService.findList();

        System.out.println("list = " + list);
    }
}