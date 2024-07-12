package com.example.ex08.service;

import com.example.ex08.dto.CommentListDTO;
import com.example.ex08.dto.CommentModifyDTO;
import com.example.ex08.dto.CommentWriteDTO;
import com.example.ex08.mapper.CommentMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceTest {

    @Mock
    CommentMapper commentMapper;

    @InjectMocks
    CommentService commentService;

    @BeforeEach
    void setUp() {
    }

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
        doReturn(List.of(new CommentListDTO())).when(commentMapper).selectList(any());
        // when
        List<CommentListDTO> foundList = commentService.findList(4L);
        // then
        assertThat(foundList)
                .isNotEmpty();
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
    void deleteComment() {
        // given
         doNothing().when(commentMapper).deleteComment(any());
        // when
        commentService.deleteComment(4L);
        // then
        verify(commentMapper, times(1)).deleteComment(any());


    }

}