package com.example.ex08.mapper;

import com.example.ex08.dto.CommentListDTO;
import com.example.ex08.dto.CommentModifyDTO;
import com.example.ex08.dto.CommentWriteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentMapperTest {

    @Autowired
    CommentMapper commentMapper;

    CommentWriteDTO commentWriteDTO;

    @Test
    void insertComment() {
        commentWriteDTO = new CommentWriteDTO();
        commentWriteDTO.setContent("test content");
        commentWriteDTO.setMemberId(2L);
        commentWriteDTO.setBoardId(4L);

        commentMapper.insertComment(commentWriteDTO);
    }

    @Test
    void selectList() {
        List<CommentListDTO> list = commentMapper.selectList(4L);
        System.out.println("list = " + list);
    }

    @Test
    void updateComment() {
        CommentModifyDTO commentModifyDTO = new CommentModifyDTO();
        commentModifyDTO.setCommentId(1L);
        commentModifyDTO.setContent("update content");
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