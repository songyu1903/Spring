package com.example.ex08.mapper;

import com.example.ex08.dto.BoardDetailDTO;
import com.example.ex08.dto.BoardListDTO;
import com.example.ex08.dto.BoardWriteDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class BoardMapperTest2 {
    @Autowired
    BoardMapper boardMapper;

    BoardWriteDTO boardWriteDTO;

//  @BeforEach 는 Junit 에서 지원하는 어노테이션이다.
//    @Test 메서드가 실행되기 전에 이 메서드를 먼저 호출한다.
//    만약 여러 메서드를 실행시키면 각각 한 번씩 이 메서드를 먼저 호출한다.
    @BeforeEach
    void setUp(){
        System.out.println("setUp() 실행!!!");

        boardWriteDTO = new BoardWriteDTO();
        boardWriteDTO.setContent("test2");
        boardWriteDTO.setTitle("test2");
        boardWriteDTO.setMemberId(1L);
    }


    @Test
    @Rollback
    void insertBoard(){
//        1. 준비 (Given)


//        2. 확인 (When)
        boardMapper.insertBoard(boardWriteDTO);
        BoardDetailDTO boardDetailDTO = boardMapper.selectBoard(boardWriteDTO.getBoardId()).get();
        System.out.println("boardDetailDTO = " + boardDetailDTO);

//        assertNotNull(boardDetailDTO.getTitle()); // Null 아니다 검증
//        assertEquals(boardDetailDTO.getTitle(), "test2");
//        3. 검증 (Than)
        assertThat(boardDetailDTO.getTitle()).isEqualTo("test2"); // assertj 메서드

//        void selectList(){

//        1. given


//        2. when
        List<BoardListDTO> list = boardMapper.selectList();

//        3. then
        assertThat(list)
                .isNotEmpty(); // list 가 비어있지 않다는것을 검증


        // list에 extracting을 사용하면 리스트가 가진 객체의 특정 필드만 뽑아낼 수 있다.
        // 현재 list에는 BoardListDTO 객체가 여러개 들어있다.
        // 이 list에 .extracting("title")을 사용하면 모든 DTO들의 title 필드만 뽑아내서 리스트를 만든다.
        // contains() 는 뽑아낸 리스트에 "test2"가 포함되어있는지 검증한다.
        assertThat(list)
                .extracting("title")
                .contains("test2");
//        };
    }

}