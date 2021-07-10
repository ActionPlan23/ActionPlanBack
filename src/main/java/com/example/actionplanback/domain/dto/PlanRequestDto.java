package com.example.actionplanback.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PlanRequestDto {
    private String title;
    private String content;
    private String planWriter;
    private String planPassword;
    private Long success;
}
