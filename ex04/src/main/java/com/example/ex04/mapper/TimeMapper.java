package com.example.ex04.mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimeMapper {
    String selectTime();
}
