package com.example.ex05.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TimeMapper {
    String selectTime();

    @Select("select sysdate from dual")
    String selectTime2();
}
