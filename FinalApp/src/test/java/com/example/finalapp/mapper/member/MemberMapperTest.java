package com.example.finalapp.mapper.member;

import com.example.finalapp.dto.member.MemberJoinDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberMapperTest {

//    필드주입
    @Autowired
    MemberMapper memberMapper;

    MemberJoinDTO memberJoinDTO;
    @BeforeEach
    void setUp() {
        memberJoinDTO = MemberJoinDTO.builder()
                .loginId("test")
                .password("1234")
                .email("test@naver.com")
                .address("test")
                .addressDetail("test")
                .zipcode("12345")
                .gender("M")
                .build();

    }

    @Test
    void insertMember() {
        // given
         memberMapper.insertMember(memberJoinDTO);
        // when
        Long memberId = memberMapper.selectMemberId(memberJoinDTO.getLoginId(), memberJoinDTO.getPassword())
                .get();
        // then
        assertThat(memberId)
                .isEqualTo(memberJoinDTO.getMemberId());

    }

    @Test
    void selectLoginId() {
        // given
         memberMapper.insertMember(memberJoinDTO);
        // when
        int cnt = memberMapper.selectLoginIdCount(memberJoinDTO.getLoginId());
        // then
        assertThat(cnt).isEqualTo(1);
    }
}