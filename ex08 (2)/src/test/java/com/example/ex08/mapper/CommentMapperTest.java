package com.example.ex08.mapper;

import com.example.ex08.dto.CommentListDTO;
import com.example.ex08.dto.CommentModifyDTO;
import com.example.ex08.dto.CommentWriteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentMapperTest {

    @Autowired
    CommentMapper commentMapper;

    @Test
    void insertComment() {
        CommentWriteDTO commentWriteDTO = new CommentWriteDTO();
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
    }
}