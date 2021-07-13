package com.example.actionplanback.domain.dto;


import com.example.actionplanback.domain.entity.Plan;
import com.example.actionplanback.domain.entity.Reply;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Getter
public class PlanAllResponseDto {

    private Long planId;
    private String title;
    private String content;
    private String writer;
    private int countReply;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public PlanAllResponseDto(Plan plan, List<Reply> replyList){

        this.planId = plan.getPlanId();
        this.title = plan.getTitle();
        this.content = plan.getContent();
        this.writer = plan.getPlanWriter();
        this.countReply = replyList.size();
        this.createdAt = plan.getCreatedAt();
        this.modifiedAt = plan.getModifiedAt();
    }
}
