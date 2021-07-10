package com.example.actionplanback.service;


import com.example.actionplanback.domain.entity.Reply;
import com.example.actionplanback.domain.repository.PlanRepository;
import com.example.actionplanback.domain.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 2021-07-10 14:41 by 최왕규
 */
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;

    @Autowired
    public ReplyService(ReplyRepository replyRepository){
        this.replyRepository = replyRepository;
    }

    // 댓글작성
    @Transactional
    public void createReply(Reply reply){
        replyRepository.save(reply);
    }

    public List<Reply> getReplyAll(Long planId){
        return replyRepository.findAllByPlanId(planId);
    }
}
