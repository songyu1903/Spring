package com.example.ex01.dependency;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// 스프링 부트에서는 단위 테스트를 지원해준다.
// 단위 테스트를 위한 클래스를 별도로 만들어야 하며 @SpringBootTest을
// 클래스에 붙여서 사용한다.
@SpringBootTest
public class CodingTest {

    @Autowired
    Coding coding;
    // 단위 테스트를 진행할 메서드에 붙이는 어노테이션
    // 해당 메서드만 개별적으로 실행 시킬 수 있다.
    @Test
    void beanTest(){
        Computer computer = coding.getComputer();
        System.out.println("computer = " + computer);

    }
}
