package com.example.ex08.dto;

import lombok.Data;

@Data
public class MemberDetailDTO {
    private Long memberId;
    private String loginId;
    private String name;
    private String gender;
}
