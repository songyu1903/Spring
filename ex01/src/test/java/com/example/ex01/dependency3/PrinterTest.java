package com.example.ex01.dependency3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PrinterTest {

    @Autowired
    Printer printer;

    @Test
    void printTest() {
        printer.print();
    }
}