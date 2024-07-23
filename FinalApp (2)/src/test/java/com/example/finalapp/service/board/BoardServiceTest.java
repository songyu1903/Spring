package com.example.finalapp.service.board;

import com.example.finalapp.dto.board.BoardDetailDTO;
import com.example.finalapp.dto.board.BoardListDTO;
import com.example.finalapp.dto.board.BoardModifyDTO;
import com.example.finalapp.dto.board.BoardWriteDTO;
import com.example.finalapp.mapper.board.BoardMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest {
    @Mock
    BoardMapper boardMapper;

    @InjectMocks
    BoardService boardService;

    @Test
    void addBoard() {
        // given
        doNothing().when(boardMapper).insertBoard(any());
        // when
        boardService.addBoard(new BoardWriteDTO());
        // then
        verify(boardMapper, times(1)).insertBoard(any());
    }

    @Test
    void removeBoard() {
        // given
        doNothing().when(boardMapper).deleteBoard(any());
        // when
        boardService.removeBoard(1L);
        // then
        verify(boardMapper, times(1)).deleteBoard(any());
    }

    @Test
    void modifyBoard() {
        // given
        doNothing().when(boardMapper).updateBoard(any());
        // when
        boardService.modifyBoard(new BoardModifyDTO());
        // then
        verify(boardMapper, times(1)).updateBoard(any());
    }

    @Test
    void findBoard() {
        // given
        BoardDetailDTO dto = BoardDetailDTO.builder()
                .title("test")
                .build();

        doReturn(Optional.of(dto)).when(boardMapper).selectBoard(any());
        // when
        BoardDetailDTO board = boardService.findBoard(1L);
        // then
        assertThat(board.getTitle()).isEqualTo("test");
    }

    @Test
    void findList() {
        // given
        doReturn(List.of(new BoardListDTO(), new BoardListDTO())).when(boardMapper).selectList();
        // when
        List<BoardListDTO> list = boardService.findList();
        // then
        assertThat(list).hasSize(2);
    }
}