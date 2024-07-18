package com.example.finalapp.mapper.board;

import com.example.finalapp.dto.board.BoardDetailDTO;
import com.example.finalapp.dto.board.BoardListDTO;
import com.example.finalapp.dto.board.BoardModifyDTO;
import com.example.finalapp.dto.board.BoardWriteDTO;
import com.example.finalapp.dto.member.MemberJoinDTO;
import com.example.finalapp.mapper.member.MemberMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardMapperTest {

    @Autowired BoardMapper boardMapper;
    @Autowired MemberMapper memberMapper;

    BoardWriteDTO boardWriteDTO;
    MemberJoinDTO memberJoinDTO;

    @BeforeEach
    void setUp() {
        memberJoinDTO = MemberJoinDTO.builder()
                 .loginId("test")
                .password("1234")
                .email("test@naver.com")
                .address("test")
                .addressDetail("test")
                .zipcode("12345")
                .gender("M")
                .build();

        memberMapper.insertMember(memberJoinDTO);

        boardWriteDTO = BoardWriteDTO.builder()
                .title("test title")
                .content("test content")
                .memberId(memberJoinDTO.getMemberId())
                .build();
    }

    @Test
    @DisplayName("게시물 삽입 & 조회 테스트")
    void insertAndSelectBoard() {
        // given (삽입)
         boardMapper.insertBoard(boardWriteDTO);
        // when (조회)
        BoardDetailDTO boardDetailDTO = boardMapper.selectBoard(boardWriteDTO.getBoardId())
                .get();
        // then (검증)
        assertThat(boardDetailDTO.getTitle())
                .isEqualTo(boardWriteDTO.getTitle());

        assertThat(boardDetailDTO)
                .extracting("title")
                .isEqualTo(boardWriteDTO.getTitle());

        assertThat(boardDetailDTO)
                .extracting("title" , "content")
                .containsExactly(boardWriteDTO.getTitle(), boardWriteDTO.getContent());
    }

    @Test
    void deleteBoard() {
        // given (삽입)
         boardMapper.insertBoard(boardWriteDTO);
        // when (실행)
        boardMapper.deleteBoard(boardWriteDTO.getBoardId());
        BoardDetailDTO boardDetailDTO = boardMapper.selectBoard(boardWriteDTO.getBoardId())
                .orElse(null);
        // then (검증)
        assertThat(boardDetailDTO).isNull();
    }

    @Test
    void updateBoard() {
        // given (삽입)
         boardMapper.insertBoard(boardWriteDTO);

        BoardModifyDTO boardModifyDTO = BoardModifyDTO.builder()
                .title("update title")
                .content("update content")
                .boardId(boardWriteDTO.getBoardId())
                .build();

        // when (실행)
        boardMapper.updateBoard(boardModifyDTO);
        BoardDetailDTO boardDetailDTO = boardMapper.selectBoard(boardWriteDTO.getBoardId()).get();
        // then (검증)
        assertThat(boardDetailDTO.getTitle()).isEqualTo("update title");

    }

    @Test
    void selectList() {
        // given (삽입)
         boardMapper.insertBoard(boardWriteDTO);
         BoardListDTO boardListDTO = BoardListDTO.builder()
                 .title("test")
                 .loginId("test")
                 .build();
        // when
        List<BoardListDTO> boardList = boardMapper.selectList();
        // then
        assertThat(boardList).hasSize(1);

    }
}