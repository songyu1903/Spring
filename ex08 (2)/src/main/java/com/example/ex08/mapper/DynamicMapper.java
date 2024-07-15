package com.example.ex08.mapper;

import com.example.ex08.dto.BoardListDTO;
import com.example.ex08.dto.DynamicDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DynamicMapper {
    List<BoardListDTO> selectList(DynamicDTO dynamicDTO);

    List<BoardListDTO> selectList2(DynamicDTO dynamicDTO);

    List<BoardListDTO> selectList3(DynamicDTO dynamicDTO);

    List<BoardListDTO> selectInTest(List<String> loginIds);
}
