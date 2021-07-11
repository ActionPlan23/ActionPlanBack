package com.example.actionplanback.domain.dto;

import com.example.actionplanback.domain.entity.Plan;
import com.example.actionplanback.domain.entity.Reply;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PlanDetailResponseDto {

    private Long planId;
    private String title;
    private String content;
    private String writer;
    private String planPassword;
    private List<ReplyResponseDto> replyList;

    public PlanDetailResponseDto(Plan plan){
        this.planId = plan.getPlanId();
        this.title = plan.getTitle();
        this.writer = plan.getPlanWriter();
        this.content = plan.getContent();
        this.planPassword = plan.getPlanPassword();

        this.replyList = plan.getReplyList().stream()
                .map(reply -> new ReplyResponseDto(reply))
                .collect(Collectors.toList());
    }

}
