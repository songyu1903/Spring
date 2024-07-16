package com.example.ex08.mapper;

import com.example.ex08.dto.BoardListDTO;
import com.example.ex08.dto.DynamicDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class DynamicMapperTest {
    @Autowired DynamicMapper dynamicMapper;

    @Test
    void selectList() {
        DynamicDTO dynamicDTO = new DynamicDTO();
//        dynamicDTO.setSearchType("title");
        dynamicDTO.setKeyword("t");

        List<BoardListDTO> list = dynamicMapper.selectList(dynamicDTO);

        System.out.println("list = " + list);
    }

    @Test
    void selectList2() {
        DynamicDTO dynamicDTO = new DynamicDTO();
        dynamicDTO.setSearchType("title");
        dynamicDTO.setKeyword("t");

        List<BoardListDTO> list = dynamicMapper.selectList2(dynamicDTO);

        System.out.println("list = " + list);
    }


    @Test
    void selectList3() {
        DynamicDTO dynamicDTO = new DynamicDTO();
        dynamicDTO.setSearchType("title");
        dynamicDTO.setKeyword("t");

        List<BoardListDTO> list = dynamicMapper.selectList3(dynamicDTO);

        System.out.println("list = " + list);
    }


    @Test
    void selectList4() {
        DynamicDTO dynamicDTO = new DynamicDTO();
        dynamicDTO.setSearchType("title");
        dynamicDTO.setKeyword("t");
        dynamicDTO.setCreatedDate("2024-07-10");

        List<BoardListDTO> list = dynamicMapper.selectList4(dynamicDTO);

        System.out.println("list = " + list);
    }

    @Test
    void selectInTest(){
        List<BoardListDTO> list = dynamicMapper.selectInTest(List.of("test", "bbb"));
        System.out.println("list = " + list);
    }

}










