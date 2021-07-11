package com.example.actionplanback.service;


import com.example.actionplanback.domain.dto.ReplyRequestDto;
import com.example.actionplanback.domain.dto.ReplyResponseDto;
import com.example.actionplanback.domain.entity.Plan;
import com.example.actionplanback.domain.entity.Reply;
import com.example.actionplanback.domain.repository.PlanRepository;
import com.example.actionplanback.domain.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 2021-07-10 14:41 by 최왕규
 */
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final PlanRepository planRepository;

    @Autowired
    public ReplyService(ReplyRepository replyRepository, PlanRepository planRepository){
        this.replyRepository = replyRepository;
        this.planRepository = planRepository;
    }

    // 댓글작성
    @Transactional
    public void createReply(ReplyRequestDto requestDto, Long planId){
        Plan plan = planRepository.findById(planId).orElseThrow(
                ()->new IllegalArgumentException("해당 Plan 글이 없습니다. id = "+planId));
        Reply reply = new Reply(requestDto, plan);
        replyRepository.save(reply);
    }
}
