package com.example.actionplanback.service;


import com.example.actionplanback.domain.dto.DeleteRequestDto;
import com.example.actionplanback.domain.dto.ReplyRequestDto;
import com.example.actionplanback.domain.entity.Plan;
import com.example.actionplanback.domain.entity.Reply;
import com.example.actionplanback.domain.repository.PlanRepository;
import com.example.actionplanback.domain.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    // 댓글 삭제 by 2021-07-12 14:02 최민서
    @Transactional
    public void deleteReply(Long id, DeleteRequestDto requestDto){
        Reply reply = replyRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 Reply 글이 없습니다. id = " + id));

        // 비밀번호가 일치할 때만 삭제가능
        if (!reply.getReplyPassword().equals(requestDto.getPassword())){
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }
        replyRepository.deleteById(id);
    }

    // 댓글 수정 by 2021-07-12 14:04 최민서
    @Transactional
    public void updateReply(Long id, ReplyRequestDto requestDto) {
        Reply reply = replyRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 Reply 글이 없습니다. id = " + id));

        // 비밀번호가 일치할때만 수정가능
        if (!reply.getReplyPassword().equals(requestDto.getReplyPassword())) {
            throw new IllegalArgumentException("댓글의 비밀번호가 틀렸습니다.");
        }
        reply.update(requestDto);
    }
}
