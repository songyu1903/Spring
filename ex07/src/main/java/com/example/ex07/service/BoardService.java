package com.example.ex07.service;

import com.example.ex07.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> findBoardList();
    BoardDTO findBoardDetail(Long boardId);
}
