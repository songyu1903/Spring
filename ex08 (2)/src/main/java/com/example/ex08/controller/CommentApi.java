package com.example.ex08.controller;

import com.example.ex08.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentApi {
    private final CommentService commentService;

    @PostMapping("/v1/comments")
    public void postComment(){

    }
}
