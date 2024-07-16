package com.example.ex08.service;

import com.example.ex08.dto.CommentListDTO;
import com.example.ex08.dto.CommentModifyDTO;
import com.example.ex08.dto.CommentWriteDTO;
import com.example.ex08.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentMapper commentMapper;

    public void addComment(CommentWriteDTO commentWriteDTO) {
        commentMapper.insertComment(commentWriteDTO);
    }

    public List<CommentListDTO> findList(Long boardId){
        return commentMapper.selectList(boardId);
    }

    public void modifyComment(CommentModifyDTO commentModifyDTO){
        commentMapper.updateComment(commentModifyDTO);
    }

    public void removeComment(Long commentId){
        commentMapper.deleteComment(commentId);
    }
}











