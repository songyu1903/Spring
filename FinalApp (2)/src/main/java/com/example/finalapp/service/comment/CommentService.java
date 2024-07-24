package com.example.finalapp.service.comment;

import com.example.finalapp.dto.comment.CommentListDTO;
import com.example.finalapp.dto.comment.CommentModifyDTO;
import com.example.finalapp.dto.comment.CommentWriteDTO;
import com.example.finalapp.mapper.comment.CommentMapper;
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

    public void modifyComment(CommentModifyDTO commentModifyDTO) {
        commentMapper.updateComment(commentModifyDTO);
    }

    public void deleteComment(Long commentId) {
        commentMapper.deleteComment(commentId);
    }
}
