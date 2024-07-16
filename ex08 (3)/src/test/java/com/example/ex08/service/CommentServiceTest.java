package com.example.ex08.service;

import com.example.ex08.dto.CommentListDTO;
import com.example.ex08.dto.CommentModifyDTO;
import com.example.ex08.dto.CommentWriteDTO;
import com.example.ex08.mapper.CommentMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceTest {
    @Mock
    CommentMapper commentMapper;

    @InjectMocks
    CommentService commentService;

    @Test
    void addComment() {
        // given
        doNothing().when(commentMapper).insertComment(any());

        // when
        commentService.addComment(new CommentWriteDTO());

        // then
        verify(commentMapper, times(1)).insertComment(any());

    }

    @Test
    void findList() {
        // given
        doReturn(List.of(new CommentListDTO(), new CommentListDTO())).when(commentMapper).selectList(any());

        // when
        List<CommentListDTO> list = commentService.findList(1L);

        // then
        Assertions.assertThat(list)
                .isNotEmpty()
                .hasSize(2);
    }

    @Test
    void modifyComment() {
        // given
        doNothing().when(commentMapper).updateComment(any());

        // when
        commentService.modifyComment(new CommentModifyDTO());

        // then
        verify(commentMapper, times(1)).updateComment(any());
    }

    @Test
    void removeComment() {
        // given
        doNothing().when(commentMapper).deleteComment(any());

        // when
        commentService.removeComment(1L);

        // then
        verify(commentMapper, times(1)).deleteComment(any());
    }
}









