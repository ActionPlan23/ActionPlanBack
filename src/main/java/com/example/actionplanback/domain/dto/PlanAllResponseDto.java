package com.example.actionplanback.domain.dto;


import com.example.actionplanback.domain.entity.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
public class PlanAllResponseDto {

    private Long planId;
    private String title;
    private String content;
    private String writer;
    private String planPassword;
    private int replyListLen;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public PlanAllResponseDto(Plan plan){

        this.planId = plan.getPlanId();
        this.title = plan.getTitle();
        this.content = plan.getContent();
        this.writer = plan.getPlanWriter();
        this.planPassword = plan.getPlanPassword();
        this.replyListLen = plan.getReplyList().size();

        this.createdAt = plan.getCreatedAt();
        this.modifiedAt = plan.getModifiedAt();
    }
}
