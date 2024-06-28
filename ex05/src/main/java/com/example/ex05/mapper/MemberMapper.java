package com.example.ex05.mapper;

import com.example.ex05.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void insertMember(MemberDTO memberDTO);

    MemberDTO selectMember(long memberId);

    void updateMember(MemberDTO memberDTO);

    MemberDTO deleteMember(long memberId);
}
