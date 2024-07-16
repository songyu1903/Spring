package com.example.ex08.controller;

import com.example.ex08.dto.CommentListDTO;
import com.example.ex08.dto.CommentModifyDTO;
import com.example.ex08.dto.CommentWriteDTO;
import com.example.ex08.service.BoardService;
import com.example.ex08.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentApi {
    private final CommentService commentService;

//  URL 경로 설정시 주의사항
//  1. 모든 자원은 복수형을 사용한다.
//  2. 상위 자원과 하위 자원의 순서를 유의한다.
//  3. HTTP Method는 반드시 목적에 맞게 설정한다.

//  HTTP Method 별 데이터 전송 방식
//    GET, DELETE : 쿼리스트링 사용
//    POST, PUT, PATCH : 바디 영역 사용
//    PathVariable 은 전부 사용 가능

//    PathVariable은 url경로상에 만든 변수이다.
//    해당 위치로 들어오는 값을 JAVA에서 꺼내 사용할 수 있다.
//    @PathVariable() 어노테이션을 이용하여 특정 변수위치에 들어온 값을
//    원하는 매개변수로 바인딩 할 수 있다.
    @GetMapping("/v1/boards/{boardId}/comments")
    public List<CommentListDTO> getComments(@PathVariable("boardId") Long boardId){
        System.out.println("boardId = " + boardId);
        List<CommentListDTO> list = commentService.findList(boardId);

//        레스트 컨트롤러에서는 자원(데이터)를 반환한다.
//        DTO같은 객체를 반환하면 자동으로 JSON 객체로 변환되어 응답 바디에 실려 간다.
//        List를 반환하면 자동으로 JSON Array로 변환되어 응답 바디에 실려 간다.
//        JSON 객체 : {"키":값}
//        JSON Array : []
//        DTO를 JSON객체로 변환하면, 필드명을 키로 사용하고 필드에 저장된 데이터를 값으로 사용한다.
//        Spring MVC 프레임워크를 사용하면 내장된 Jackson라이브러리를 활용하여 자동으로 변환해준다.
//        통신을 통해 데이터를 전송하게되는데 전송하기 좋은 형태로 변환하는 과정을 [직렬화]라고한다.
//        우리는 DTO를 JSON 형태로 JSON직렬화를 하여 보내는 것이다.
        return list;
    }

//    @RequestBody 요청의 본문영역의 JSON데이터를 특정 객체로 역직렬화 시켜준다.
//    JSON역직렬화 : JSON을 우리의 객체 형태로 변환
    @PostMapping("/v1/boards/{boardId}/comments")
    public void postComment(@PathVariable("boardId") Long boardId,
                            @RequestBody CommentWriteDTO commentWriteDTO,
                            @SessionAttribute("memberId") Long memberId){
        System.out.println("CommentWriteDTO = " + commentWriteDTO);
        commentWriteDTO.setBoardId(boardId);
        commentWriteDTO.setMemberId(memberId);

        commentService.addComment(commentWriteDTO);
    }

    @PatchMapping("/v1/comments/{commentId}")
    public void patchComment(@PathVariable("commentId") Long commentId,
                             @RequestBody CommentModifyDTO commentModifyDTO){

        commentModifyDTO.setCommentId(commentId);
        commentService.modifyComment(commentModifyDTO);
    }

    @DeleteMapping("/v1/comments/{commentId}")
    public void deleteComment(@PathVariable("commentId") Long commentId){
        commentService.removeComment(commentId);
    }
}













