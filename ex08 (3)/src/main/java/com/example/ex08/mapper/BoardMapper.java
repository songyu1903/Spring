package com.example.ex08.mapper;

import com.example.ex08.dto.BoardDetailDTO;
import com.example.ex08.dto.BoardListDTO;
import com.example.ex08.dto.BoardWriteDTO;
import com.example.ex08.dto.SearchDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    void insertBoard(BoardWriteDTO boardWriteDTO);

    Optional<BoardDetailDTO> selectBoard(Long boardId);

    List<BoardListDTO> selectList();

    List<BoardListDTO> searchList(SearchDTO searchDTO);

}














