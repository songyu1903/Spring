package com.example.finalapp.api.comment;

import com.example.finalapp.dto.comment.CommentListDTO;
import com.example.finalapp.dto.comment.CommentModifyDTO;
import com.example.finalapp.dto.comment.CommentWriteDTO;
import com.example.finalapp.service.comment.CommentService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor

public class CommentApi {
    private final CommentService commentService;

    @PostMapping("/boards/{boardId}/comments")
    public void commentWrite(@PathVariable("boardId") Long boardId,
                             @RequestBody CommentWriteDTO commentWriteDTO,
                             @SessionAttribute(value = "memberId" , required = false) Long memberId){

        commentWriteDTO.setBoardId(boardId);
        commentWriteDTO.setMemberId(memberId);
        log.info("commentWriteDTO : {}", commentWriteDTO);

        commentService.addComment(commentWriteDTO);
    }

    @GetMapping("/boards/{boardId}/comments")
    public List<CommentListDTO> commentList(@PathVariable("boardId") Long boardId){
        return commentService.findList(boardId);
    }
    @PatchMapping("/comments/{commentId}")
    public void modifyComment(@RequestBody CommentModifyDTO commentModifyDTO,
                              @PathVariable("commentId") Long commentId){
        commentModifyDTO.setCommentId(commentId);
        commentService.modifyComment(commentModifyDTO);
    }
    @DeleteMapping("/comments/{commentId}")
    public void removeComment(@PathVariable("commentId") Long commentId){
        commentService.deleteComment(commentId);
    }
}
