package com.example.finalapp.service.comment;

import com.example.finalapp.dto.comment.CommentListDTO;
import com.example.finalapp.dto.comment.CommentModifyDTO;
import com.example.finalapp.dto.comment.CommentWriteDTO;
import com.example.finalapp.dto.page.PageRequestDTO;
import com.example.finalapp.dto.page.SliceDTO;
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

    public SliceDTO<CommentListDTO> findListWithSlice(Long boardId, PageRequestDTO pageRequestDTO){
        List<CommentListDTO> list = commentMapper.selectListWithSlice(boardId, pageRequestDTO);

        boolean hasNext = list.size() > pageRequestDTO.getAmount();

        if(hasNext) {
            list.remove(pageRequestDTO.getAmount());
        }

        return new SliceDTO<CommentListDTO>(hasNext, list);
    }


    public void modifyComment(CommentModifyDTO commentModifyDTO) {
        commentMapper.updateComment(commentModifyDTO);
    }

    public void removeComment(Long commentId) {
        commentMapper.deleteComment(commentId);
    }
}
