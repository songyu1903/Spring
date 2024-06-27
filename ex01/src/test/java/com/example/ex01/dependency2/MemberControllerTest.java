package com.example.ex01.dependency2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberControllerTest {
    @Autowired
    private MemberController memberController;

    @Test
    void memberTest(){
        System.out.println("memberController = " + memberController);

        MemberDAO memberDAO = memberController.getMemberDAO();
        System.out.println("memberDAO = " + memberDAO);
    }
}