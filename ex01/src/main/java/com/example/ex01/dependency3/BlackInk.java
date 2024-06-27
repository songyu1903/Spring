package com.example.ex01.dependency3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("blackInk")
public abstract class BlackInk implements Ink{
    public void myColor(){
        System.out.println("*********Black*********");
    }
}
