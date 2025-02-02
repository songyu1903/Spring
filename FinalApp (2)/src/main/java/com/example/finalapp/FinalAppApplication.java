package com.example.finalapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FinalAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalAppApplication.class, args);
    }

}
