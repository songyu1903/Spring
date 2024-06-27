package com.example.ex01.dependency3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("pinkInk")
public abstract class PinkInk implements Ink{
    public void myColor(){
        System.out.println("=========Pink=========");
    }
}
