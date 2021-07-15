package com.example.actionplanback.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * 2021-07-10 14:29  by 최왕규
 */

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ReplyRequestDto {

    private String replyContent;
    private String replyWriter;
    private String replyPassword;
}
