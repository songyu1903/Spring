package com.example.finalapp.service.member;

import com.example.finalapp.dto.member.MemberJoinDTO;
import com.example.finalapp.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;

    /**
     * 중복 아이디 처리와 회원 가입 처리
     * @param memberJoinDTO 회원 정보
     */
    public void addMember(MemberJoinDTO memberJoinDTO) {
        int cnt = memberMapper.selectLoginIdCount(memberJoinDTO.getLoginId());

        if(cnt != 0){
            throw new IllegalStateException("중복된 회원 아이디");
        }

        memberMapper.insertMember(memberJoinDTO);
    }

    public Long findMemberId(String loginId, String password){
        return memberMapper.selectMemberId(loginId, password)
                .orElseThrow(() -> new IllegalStateException("존재하지 않느 회원 정보"));
    }

    // 중복검사
    public boolean isDuplicateLoginId(String loginId){
        return memberMapper.selectLoginIdCount(loginId) > 0;
    }
}
