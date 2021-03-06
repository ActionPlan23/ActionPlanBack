package com.example.actionplanback.domain.dto;

import com.example.actionplanback.domain.entity.Plan;
import com.example.actionplanback.domain.entity.Reply;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PlanDetailResponseDto {

    private Long planId;
    private String title;
    private String content;
    private String writer;
    private List<ReplyResponseDto> replyList;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public PlanDetailResponseDto(Plan plan, List<ReplyResponseDto> replyList){
        this.planId = plan.getPlanId();
        this.title = plan.getTitle();
        this.writer = plan.getPlanWriter();
        this.content = plan.getContent();
        this.replyList = replyList;
        this.createdAt = plan.getCreatedAt();
        this.modifiedAt = plan.getModifiedAt();
    }

}
