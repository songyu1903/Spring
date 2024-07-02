package com.example.ex07.mapper;

import com.example.ex07.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    void insertBoard(BoardDTO boardDTO);
    BoardDTO selectBoard(Long boardId);
    void updateViewCnt(Long boardDTO);

    List<BoardDTO> selectAll();

    Optional<BoardDTO> selectOne(Long boardId);
}
