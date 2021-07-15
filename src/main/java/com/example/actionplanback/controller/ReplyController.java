package com.example.actionplanback.controller;


import com.example.actionplanback.domain.dto.DeleteRequestDto;
import com.example.actionplanback.domain.dto.ReplyRequestDto;
import com.example.actionplanback.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 2021-07-10 14:40 by 최왕규
 */
@CrossOrigin(origins = "http://hyeonju.shop")
@RestController
public class ReplyController {

    private final ReplyService replyService;

    @Autowired
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    // 댓글 작성 by 2021-07-10 14:40 최왕규
    @PostMapping("/api/reply/{planId}")
    public Map<String, Long> createReply(@PathVariable Long planId, @RequestBody ReplyRequestDto replyRequestDto) {

        Long replyId = replyService.createReply(replyRequestDto, planId);

        Map<String, Long> replyMap = new HashMap<>();
        replyMap.put("replyId", replyId);
        return replyMap;

    }

    // 댓글 삭제 by 2021-07-12-19:18 최민서
    @DeleteMapping("/api/reply/{replyId}")
    public Map<String, Long> deleteReply(@PathVariable Long replyId, @RequestBody DeleteRequestDto requestDto) {
        Long returnReplyId = replyService.deleteReply(replyId, requestDto);

        Map<String, Long> deletedReplyId = new HashMap<>();
        deletedReplyId.put("replyId", returnReplyId);

        return deletedReplyId;
    }

    // 댓글 수정 by 2021-07-12-19:18 최민서
    @PutMapping("/api/reply/{replyId}")
    public Map<String, Long> updateReply(@PathVariable Long replyId, @RequestBody ReplyRequestDto requestDto) {
        Long returnReplyId = replyService.updateReply(replyId, requestDto);

        Map<String, Long> updatedReplyId = new HashMap<>();
        updatedReplyId.put("replyId", returnReplyId);
        return updatedReplyId;
    }
}
