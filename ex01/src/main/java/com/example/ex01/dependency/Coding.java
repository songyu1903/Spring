package com.example.ex01.dependency;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Data는 롬복에서 지원하는 어노테이션이다.
// 롬복은 항상 똑같은 틀(보일러 플레이트 코드)를 최소화 시켜주는 라이브러리이다.
// Data를 작성하면 getter, setter, toString, equals, hashcode 재정의를
// 자동으로 해준다.
@Data
// @Component 스프릉 빈으로 등록하는 어노테이션이다.
// 빈으로 등록된 클래스의 객체는 스프링 컨테이너에 생성되고 관리된다.
// 의존성 주입을 스프링의 도움을 받아 하고 싶다면 반드시 빈으로 등록해야한다.
@Component
public class Coding {
//  @Autowired 는 빈으로 등록된 객체를 주입하는 어노테이션이다.
//    스프링이 컨테이너에서 해당 필드와 타입이 일치하는 객체를 찾아 자동으로 주입해준다.
//    개발자가 직접 new로 객체를 찍을 필요가 없다.
    @Autowired
    private Computer computer;

}
