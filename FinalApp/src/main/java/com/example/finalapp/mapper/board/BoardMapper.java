package com.example.finalapp.mapper.board;

import com.example.finalapp.dto.board.BoardDetailDTO;
import com.example.finalapp.dto.board.BoardListDTO;
import com.example.finalapp.dto.board.BoardModifyDTO;
import com.example.finalapp.dto.board.BoardWriteDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    void insertBoard(BoardWriteDTO boardWriteDTO);

    void deleteBoard(Long boardId);

    void updateBoard(BoardModifyDTO boardModifyDTO);

    Optional<BoardDetailDTO> selectBoard(Long boardId);

    List<BoardListDTO> selectList();
}
