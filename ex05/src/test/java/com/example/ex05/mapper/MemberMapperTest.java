package com.example.ex05.mapper;

import com.example.ex05.dto.MemberDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Member;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberMapperTest {

    @Autowired
    MemberMapper memberMapper;

    @Test
    void insertMember() {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("김송호");
        memberDTO.setAge(26);

        memberMapper.insertMember(memberDTO);
    }

    @Test
    void selectMember() {
        MemberDTO memberDTO = memberMapper.selectMember(1);
        System.out.println("memberDTO = " + memberDTO);
    }

    @Test
    void updateMember() {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("update name");
        memberDTO.setAge(27);
        memberDTO.setMemberId(1L);

        memberMapper.updateMember(memberDTO);
        memberMapper.selectMember(1);
    }

    @Test
    void deleteMember() {
        memberMapper.deleteMember(1L);
    }

    @Test
    void insertDummy(){
        for (int i = 0; i < 10; i++) {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setAge(10 + i);
            memberDTO.setName("test" + i);

            memberMapper.insertMember(memberDTO);
        }
    }

    @Test
    void selectAll() {
        List<MemberDTO> memberDTOList = memberMapper.selectAll();
        System.out.println("memberDTOList = " + memberDTOList);
    }
}