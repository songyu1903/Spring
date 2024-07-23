package com.example.finalapp.mapper.member;

import com.example.finalapp.dto.member.MemberJoinDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    // 회원가입
    void insertMember(MemberJoinDTO memberJoinDTO);

    // 로그인
    Optional<Long> selectMemberId(@Param("loginId") String loginId,
                                  @Param("password") String password);

    // 아이디 중복 검사
    int selectLoginIdCount(String loginId);
}













