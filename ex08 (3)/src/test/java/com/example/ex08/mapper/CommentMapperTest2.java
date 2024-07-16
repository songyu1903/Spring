package com.example.ex08.mapper;

import com.example.ex08.dto.CommentListDTO;
import com.example.ex08.dto.CommentModifyDTO;
import com.example.ex08.dto.CommentWriteDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CommentMapperTest2 {
    @Autowired CommentMapper commentMapper;

    CommentWriteDTO commentWriteDTO;

    @BeforeEach
    void setUp() {
        commentWriteDTO = new CommentWriteDTO();
        commentWriteDTO.setContent("test comment");
        commentWriteDTO.setMemberId(1L);
        commentWriteDTO.setBoardId(21L);
    }

    @Test
    void insertComment() {
//        given
        commentMapper.insertComment(commentWriteDTO);

//        when
        List<CommentListDTO> list = commentMapper.selectList(21L);

//        then
        assertThat(list)
                .extracting("content")
                .contains("test comment");
    }

    @Test
    void updateComment() {
        // given
        commentMapper.insertComment(commentWriteDTO);

        // when
        CommentModifyDTO commentModifyDTO = new CommentModifyDTO();
        commentModifyDTO.setCommentId(commentWriteDTO.getCommentId());
        commentModifyDTO.setContent("modify comment");

        commentMapper.updateComment(commentModifyDTO);

        // then
        List<CommentListDTO> list = commentMapper.selectList(commentWriteDTO.getBoardId());
        assertThat(list)
                .extracting("content")
                .contains("modify comment");
    }

    @Test
    void deleteComment() {
        // given
         commentMapper.insertComment(commentWriteDTO);
        // when
        commentMapper.deleteComment(commentWriteDTO.getCommentId());
        // then
        List<CommentListDTO> list = commentMapper.selectList(commentWriteDTO.getBoardId());
        assertThat(list)
                .extracting("commentId")
                .doesNotContain(commentWriteDTO.getCommentId());
    }
}










