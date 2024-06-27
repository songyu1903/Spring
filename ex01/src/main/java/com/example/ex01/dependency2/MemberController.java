package com.example.ex01.dependency2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
// @RequiredArgsConstructor 는 롬복에서 제공하는 어노테이션이다.
// final이 붙은 필드를 초기화해주는 생성자를 만들어준다.
// 생성자가 1개만있으면 자동으로 @Autowired 가 붙기 때문에 생성자 주입이 가능하다.
@RequiredArgsConstructor
public class MemberController {
    private final MemberDAO memberDAO;

//    @Autowired
//    public MemberController(MemberDAO memberDAO) {
//        this.memberDAO = memberDAO;
//    }
}


