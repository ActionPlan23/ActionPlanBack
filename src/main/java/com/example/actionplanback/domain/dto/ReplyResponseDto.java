package com.example.actionplanback.domain.dto;

import com.example.actionplanback.domain.entity.Reply;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReplyResponseDto {
    private Long replyId;

    private String replyContent;
    private String replyWriter;

    public ReplyResponseDto(Reply reply){
        this.replyId = reply.getReplyId();
        this.replyContent = reply.getReplyContent();
        this.replyWriter = reply.getReplyWriter();
    }

}
