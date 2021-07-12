package com.example.actionplanback.controller;


import com.example.actionplanback.domain.dto.DeleteRequestDto;
import com.example.actionplanback.domain.dto.ReplyRequestDto;
import com.example.actionplanback.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 2021-07-10 14:40 by 최왕규 200ok 어찌보내누.
 */

@RestController
public class ReplyController {

    private final ReplyService replyService;

    @Autowired
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    // 댓글작성 최왕규
    @PostMapping("/api/reply/{planId}")
    public void createReply(@PathVariable Long planId, @RequestBody ReplyRequestDto replyRequestDto) {
        replyService.createReply(replyRequestDto, planId);
    }

    // 댓글 삭제 by 2021-07-12-19:18 최민서
    @DeleteMapping("/api/reply/{replyId}")
    public void deleteReply(@PathVariable Long replyId, @RequestBody DeleteRequestDto requestDto) {
        replyService.deleteReply(replyId, requestDto);
    }

    // 댓글 수정 by 2021-07-12-19:18 최민서
    @PutMapping("/api/reply/{replyId}")
    public void updateReply(@PathVariable Long replyId, @RequestBody ReplyRequestDto requestDto) {
        replyService.updateReply(replyId, requestDto);
    }
}
