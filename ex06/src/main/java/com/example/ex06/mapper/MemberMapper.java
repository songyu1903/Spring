package com.example.ex06.mapper;

import com.example.ex06.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    void insertMember(MemberDTO memberDTO);

    MemberDTO selectMember(Long memberId);

    void updateMember(MemberDTO memberDTO);

    void deleteMember(Long memberId);

    List<MemberDTO> selectAll();
}













