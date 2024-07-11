package com.example.ex08.mapper;

import com.example.ex08.dto.BoardDetailDTO;
import com.example.ex08.dto.BoardWriteDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class BoardMapperTest2 {
    @Autowired
    BoardMapper boardMapper;

    @Test
    @Rollback
    void insertBoard(){
        BoardWriteDTO boardWriteDTO = new BoardWriteDTO();
        boardWriteDTO.setContent("test2");
        boardWriteDTO.setTitle("test2");
        boardWriteDTO.setMemberId(1L);
        boardMapper.insertBoard(boardWriteDTO);

        BoardDetailDTO boardDetailDTO = boardMapper.selectBoard(boardWriteDTO.getBoardId()).get();
        System.out.println("boardDetailDTO = " + boardDetailDTO);


//        assertEquals(boardDetailDTO.getTitle(), "test2");
        assertThat(boardDetailDTO.getTitle()).isEqualTo("test2");
    }
}