package com.example.finalapp.mapper.comment;

import com.example.finalapp.dto.comment.CommentListDTO;
import com.example.finalapp.dto.comment.CommentModifyDTO;
import com.example.finalapp.dto.comment.CommentWriteDTO;
import com.example.finalapp.dto.page.PageRequestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    void insertComment(CommentWriteDTO commentWriteDTO);

    List<CommentListDTO> selectList(Long boardId);

    void updateComment(CommentModifyDTO commentModifyDTO);

    void deleteComment(Long commentId);

    List<CommentListDTO> selectListWithSlice(@Param("boardId") Long boardId,
                                             @Param("pageDTO") PageRequestDTO pageRequestDTO);
}
