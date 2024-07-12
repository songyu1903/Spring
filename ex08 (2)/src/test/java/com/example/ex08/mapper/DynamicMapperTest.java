package com.example.ex08.mapper;

import com.example.ex08.dto.BoardListDTO;
import com.example.ex08.dto.DynamicDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DynamicMapperTest {

    @Autowired
    DynamicMapper dynamicMapper;

    @Test
    void selectList() {
        DynamicDTO dynamicDTO = new DynamicDTO();
        dynamicDTO.setSearchType("loginId");
        dynamicDTO.setKeyword("k");

        List<BoardListDTO> list = dynamicMapper.selectList(dynamicDTO);
        System.out.println("list = " + list);
    }

    @Test
    void selectList2() {
        DynamicDTO dynamicDTO = new DynamicDTO();
        dynamicDTO.setSearchType("title");
        dynamicDTO.setKeyword("밥");

        List<BoardListDTO> list = dynamicMapper.selectList2(dynamicDTO);
        System.out.println("list = " + list);
    }

    @Test
    void selectList3() {
        DynamicDTO dynamicDTO = new DynamicDTO();
        dynamicDTO.setSearchType("loginId");
        dynamicDTO.setKeyword("a");

        List<BoardListDTO> list = dynamicMapper.selectList2(dynamicDTO);
        System.out.println("list = " + list);
    }
}