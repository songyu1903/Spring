package com.example.ex08.mapper;

import com.example.ex08.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;


@Mapper
public interface MemberMapper {
    void insertMember(MemberDTO memberDTO);

//    MyBatis는 쿼리를 완성시킬 때 필요한 값을 파라미터로 전달받는다.
//    MyBatis는 기본적으로 파라미터를 1개만 사용할 수 있다.
//    그래서 여러값을 전달하고 싶다면 DTO를 만들거나 Map을 사용해야한다.
//    Spring에서 MyBatis를 사용하는 경우에는 @Param 어노테이션과 함께 여러 파라미터를 설정할 수 있다.
//    Spring이 내부에서 map으로 변환하여 넘겨준다.
    Optional<Long> selectMemberId(@Param("loginId") String loginId,
                                  @Param("password") String password);

    int selectLoginIdCount(String loginId);
}
