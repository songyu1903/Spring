package com.example.ex04.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TimeMapper {
    // xml 파일의 id와 같은 메서드 이름을 사용하면 자동으로 SQL과 추상 메서드가 매핑된다.

    String selectTime();

    @Select("select sysdate from dual")
    String selectTime2();
}
