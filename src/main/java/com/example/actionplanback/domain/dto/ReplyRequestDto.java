package com.example.actionplanback.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * 2021-07-10 14:29  by 최왕규 짱짱맨
 */

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ReplyRequestDto {

    private String replyContent;
    private String replyWriter;
    private String replyPassword;

    // 최왕규: 이거확실하게 public 생성자로 만들지말지 고민 그리고 생성자 만들면 그냥들어오는지궁금해짐
}
