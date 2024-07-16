package com.example.ex08.service;

import com.example.ex08.dto.BoardDetailDTO;
import com.example.ex08.dto.BoardListDTO;
import com.example.ex08.dto.BoardWriteDTO;
import com.example.ex08.mapper.BoardMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest2 {
    @Mock
    BoardMapper boardMapper;

    @InjectMocks
    BoardService boardService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void addBoard() {
        // given
        // 스터빙
        // 우리가 만든 Mock객체는 껍데기만 있고 아무런 기능을하지 않기 때문에
        // 테스트 코드에 적합한 기능으로 재정의하여 사용한다. 이를 스터빙이라고 한다.

        // boardMapper의 insertBoard() 메서드에 아무거나(any) 한 개 들어오면 아무짓도 하지 말아라(doNothing)
        doNothing().when(boardMapper).insertBoard(any());

        // when
        boardService.addBoard(new BoardWriteDTO());

        // then
        verify(boardMapper, times(1)).insertBoard(any());
    }

    @Test
    void findBoard() {
        // given
        BoardDetailDTO boardDetailDTO = new BoardDetailDTO();
        boardDetailDTO.setTitle("test");

        // doReturn()
        // 우리가 테스트하기 좋은 값을 리턴하도록 스터빙한다.
        // 단, Mock객체의 메서드 선언부와 동일한 타입의 값을 반환해야한다.
        doReturn(Optional.of(boardDetailDTO)).when(boardMapper).selectBoard(any());

        // when
        BoardDetailDTO foundBoard = boardService.findBoard(1L);

        // then
        assertThat(foundBoard)
                .isNotNull()
                .isEqualTo(boardDetailDTO);
    }

    @Test
    void findBoardException(){
        // given
        doReturn(Optional.empty()).when(boardMapper).selectBoard(any());

        // when
        // then

//      assertThatThrownBy(람다식) : 람다식에서 예외가 터지는 것을 기대하고 검증한다.
//        isInstanceOf() : 발생한 예외의 타입을 검증한다.
//        hasMessageContaining() : 발생한 예외 메세지에 포함되는지 검증한다.
        assertThatThrownBy(() -> boardService.findBoard(1L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("존재하지 않는");
    }

    @Test
    void findList() {
        // given
        doReturn(List.of(new BoardListDTO())).when(boardMapper).selectList();

        // when
        List<BoardListDTO> list = boardService.findList();

        // then
        assertThat(list)
                .isNotEmpty()
                .hasSize(1);
    }
}









