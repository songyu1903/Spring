package com.example.ex01.dependency3;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@Component
public class Printer {

    private final Ink ink;

    @Autowired
    public Printer(@Qualifier("blackInk") Ink ink) {
        this.ink = ink;
    }

    public void print() {
       ink.myColor();
    }
}
