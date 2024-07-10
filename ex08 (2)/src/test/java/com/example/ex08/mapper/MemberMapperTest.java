package com.example.ex08.mapper;

import com.example.ex08.dto.MemberDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberMapperTest {
    @Autowired MemberMapper memberMapper;

    @Test
    void insertMember() {
//        1. 준비
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setLoginId("test");
        memberDTO.setPassword("1234");
        memberDTO.setName("test");
        memberDTO.setAddress("서울시");
        memberDTO.setAddressDetail("노원구");
        memberDTO.setZipcode("12345");
        memberDTO.setGender("F");
//        2. 실행
        memberMapper.insertMember(memberDTO);
//        3. 검증(확인)
    }

    @Test
    void selectMemberId() {
//        1. 준비
//        2. 실행
        Optional<Long> opt = memberMapper.selectMemberId("test", "1234");
//        3. 검증
        Long memberId = opt.get();
        System.out.println("memberId = " + memberId);
    }
}






