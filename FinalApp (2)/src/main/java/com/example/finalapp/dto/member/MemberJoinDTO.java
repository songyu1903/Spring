package com.example.finalapp.dto.member;

import lombok.*;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor @Builder
public class MemberJoinDTO {
    private Long memberId;
    private String loginId;
    private String password;
    private String gender;
    private String email;
    private String address;
    private String addressDetail;
    private String zipcode;
}













