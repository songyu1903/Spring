package com.example.ex06.mapper;

import com.example.ex06.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void insertBoard(BoardDTO boardDTO);

    BoardDTO selectBoard(Long boardId);

    List<BoardDTO> selectAll();

    void updateBoard(BoardDTO boardDTO);

    void deleteBoard(Long boardId);
}











