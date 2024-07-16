package com.example.ex08.mapper;

import com.example.ex08.dto.CommentListDTO;
import com.example.ex08.dto.CommentModifyDTO;
import com.example.ex08.dto.CommentWriteDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    void insertComment(CommentWriteDTO commentWriteDTO);

    List<CommentListDTO> selectList(Long boardId);

    void updateComment(CommentModifyDTO commentModifyDTO);

    void deleteComment(Long commentId);
}













