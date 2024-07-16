package com.example.ex08.service;

import com.example.ex08.dto.*;
import com.example.ex08.exception.DuplicatedLoginIdException;
import com.example.ex08.exception.LoginException;
import com.example.ex08.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;

    public void addMember(MemberDTO memberDTO) throws DuplicatedLoginIdException{
        int result = memberMapper.selectLoginIdCount(memberDTO.getLoginId());

        if(result != 0){
            throw new DuplicatedLoginIdException("중복된 아이디가 존재합니다.");
        }

        memberMapper.insertMember(memberDTO);
    }

    public Long findMemberId(String loginId, String password) {
//        옵셔널은 메소드의 반환타입으로만 사용하는것을 권장한다.
//        ex) mapper 인터페이스가 가진 메서드의 반환타입을 optional로 사용
//        보통 mapper의 반환으로 옵셔널을 사용하고 service 클래스에서 옵셔널을 벗겨서 반환한다.
//        Optional<Long> opt = memberMapper.selectMemberId(loginId, password);
//        Long memberId = opt.orElseThrow(() -> new LoginException("일치하는 회원정보가 없습니다."));
//        return memberId;
        return memberMapper.selectMemberId(loginId, password)
                .orElseThrow(() -> new LoginException("일치하는 회원정보가 없습니다."));
    }

    public int checkLoginId(String loginId){
        return memberMapper.selectLoginIdCount(loginId);
    }

    public List<MemberDTO> selectListMember(MemberDTO memberDTO){
        return memberMapper.selectListMember(memberDTO);
    }
    public List<MemberListDTO> findMemberList(MemberSearchDTO memberSearchDTO){
        return memberMapper.searchMemberList(memberSearchDTO);
    }

}







