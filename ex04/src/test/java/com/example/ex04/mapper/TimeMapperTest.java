package com.example.ex04.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TimeMapperTest {
    @Autowired
    TimeMapper timeMapper;

    @Test
    void selectTime() {
        String time = timeMapper.selectTime();
        System.out.println("time = " + time);
    }
    @Test
    void selectTime2(){
        String time2 = timeMapper.selectTime2();
        System.out.println("time2 = " + time2);
    }
}