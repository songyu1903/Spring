package com.example.ex08.dto;

import lombok.Data;

@Data
public class SearchDTO {
    private String searchType;
    private String keyword;
    private String createdDate;
}
