package com.example.finalapp.service.member;

import com.example.finalapp.dto.member.MemberJoinDTO;
import com.example.finalapp.mapper.member.MemberMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {
    @Mock
    MemberMapper memberMapper;

    @InjectMocks
    MemberService memberService;

    @Test
    void addMember() {
        // given
        doReturn(0).when(memberMapper).selectLoginIdCount(any());
        doNothing().when(memberMapper).insertMember(any());
        // when
        memberService.addMember(MemberJoinDTO.builder().build());
        // then
        verify(memberMapper, times(1)).selectLoginIdCount(any());
        verify(memberMapper, times(1)).insertMember(any());
    }

    @Test
    void addMemberWithException(){
        // given
        doReturn(1).when(memberMapper).selectLoginIdCount(any());

//        만약 스터빙을 했는데 해당 메서드가 실행되지 않으면 테스트 실패가 뜬다.
//        그러므로 실행되는 메서드만 스터빙을 해준다.
//        doNothing().when(memberMapper).insertMember(any());

        // when, then
        assertThatThrownBy(() -> memberService.addMember(new MemberJoinDTO()))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("중복된");
    }

    @Test
    void findMemberId() {
        // given
        doReturn(Optional.of(1L)).when(memberMapper).selectMemberId(any(), any());
        // when
        Long memberId = memberService.findMemberId("test", "1234");
        // then
        assertThat(memberId).isEqualTo(1L);
    }

    @Test
    void isDuplicateLoginId() {
        // given
        doReturn(1).when(memberMapper).selectLoginIdCount(any());
        // when
        boolean result = memberService.isDuplicateLoginId("123");
        // then
        assertThat(result).isTrue();
    }
}









