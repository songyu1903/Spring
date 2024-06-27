package com.example.ex03.dto;

import lombok.Data;

@Data
public class MemberDTO {
    private String loginId;
    private String password;
    private String name;
    private int age;
}
