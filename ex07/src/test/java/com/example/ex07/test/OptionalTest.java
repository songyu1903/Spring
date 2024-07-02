package com.example.ex07.test;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalTest {
    /*
    Optional<T>
    옵셔널 클래스는 NPE를 방어하기 위해 사용한다.
    개발을 할 때 가장 많이 발생하는 예외 중 하나가 NPE 이다.
    참조변수에 들어있는 값이 null인 경우 접근 연산자(.) 를 이용하여 메서드나 필드에 접근하면
    NPE(NullPointException)가 발생하므로 프로그램이 강종될 수 있다.

    그러므로 if문을 이용하여 해당 값이 null인지 검사를 해야하는데 null이 나올 수 있는 경우의 수가
    너무 많아서 if문으로 처리하면 개발이 피곤해진다.

    Optional 타입은 null 체크를 보다 간결하고 안전하게 코드를 작성하도록 도와준다.
    */

    @Test
    void ex01(){
//        옵셔널 객체 생성하기
//        1. empty()
        Optional<Object> opt = Optional.empty();
//        비어있는 옵셔널 객체를 생성한다.
//        2. of()
//        값을 저장하고 있는 옵셔널 객체를 생성한다.
//        값이 확실하게 null이 아닌 경우에만 사용한다.
//        만약 null을 저장하면 NPE가 발생한다.
        Optional<String> opt2 = Optional.of("안녕");
        Optional<Long> opt3 = Optional.of(1L);
//        Optional.of(null);

//        3. oFNullable()
//        값을 저장하고 있는 옵셔널 객체를 생성한다.
//        값이 null일 수도 있는 경우 사용한다.
        Optional<String> opt4 = Optional.ofNullable("10");
        Optional<String> opt5 = Optional.ofNullable(null);

//        옵셔널 객체는 값을 저장할 수 있으며 저장한 값이 null인지 체크하거나, null이면 다른값으로
//        대체해서 반환하는 등의 메서드를 지원한다.
    }

    @Test
    void ex02(){
//        옵셔널 객체의 메서드

//        1. get()
//        옵셔널 객체의 저장된 값을 반환한다.
//        null 인 경우 NoSuchElementException 이 발생된다.
//        그러므로 get()은 null이 아니라는 확신이 있을 때 사용한다.
        Optional<String> opt1 = Optional.of("test");
        Optional<Object> opt2 = Optional.ofNullable(null);

        String result1 = opt1.get();
        System.out.println("result1 = " + result1);

        Object result2 = opt2.get();
        System.out.println("result2 = " + result2);
    }

    @Test
    void ex03(){
//        2. orElse()
//        opt.orElse(대체값)
//        옵셔널 객체에 저장된 값을 반환한다.
//        만약 null인 경우 [대체값] 이 반환된다.
//
        Optional<String> opt1 = Optional.of("test");
        Optional<Object> opt2 = Optional.ofNullable(null);

        String result1 = opt1.orElse("hi~");
        System.out.println("result1 = " + result1);

        Object result2 = opt2.orElse("값이 없다");
        System.out.println("result2 = " + result2);
    }
    @Test
    void ex04(){
//        3. orElseThrow()
//        opt.orElseThrow(특정 예외)
//        옵셔널 객체에 저장된 값을 반환한다.
//        만약 null인 경우 [특정 예외]가 발생된다.
        Optional<String> opt1 = Optional.of("test");
        Optional<Object> opt2 = Optional.ofNullable(null);

        String result1 = opt1.orElseThrow(() -> new IllegalStateException("조회 결과 없음!!!"));
        System.out.println("result1 = " + result1);

        Object result2 = opt2.orElseThrow(() -> new IllegalStateException("조회 결과 없음!!!"));
        System.out.println("result2 = " + result2);

    }
}
