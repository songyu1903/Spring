package com.example.ex08.dto;

import lombok.Data;

@Data
public class MemberDTO {
    private Long memberId;
    private String loginId;
    private String password;
    private String name;
    private String address;
    private String addressDetail;
    private String zipcode;
    private String gender;
}
