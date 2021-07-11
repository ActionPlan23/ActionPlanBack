package com.example.actionplanback.controller;


import com.example.actionplanback.domain.dto.ReplyRequestDto;
import com.example.actionplanback.domain.dto.ReplyResponseDto;
import com.example.actionplanback.domain.entity.Reply;
import com.example.actionplanback.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 2021-07-10 14:40 by 최왕규 200ok 어찌보내누.
 */

@RestController
public class ReplyController {

    private final ReplyService replyService;

    @Autowired
    public ReplyController(ReplyService replyService){
        this.replyService = replyService;
    }

    // 댓글작성 최왕규
    @PostMapping("/api/reply/{planId}")
    public void createReply(@PathVariable Long planId, @RequestBody ReplyRequestDto replyRequestDto){
        replyService.createReply(replyRequestDto, planId);
    }
}
