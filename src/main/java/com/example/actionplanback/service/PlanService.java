package com.example.actionplanback.service;

import com.example.actionplanback.domain.dto.*;
import com.example.actionplanback.domain.entity.Plan;
import com.example.actionplanback.domain.entity.Reply;
import com.example.actionplanback.domain.repository.PlanRepository;
import com.example.actionplanback.domain.repository.ReplyRepository;
import com.example.actionplanback.exception.ApiRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PlanService {

    private final PlanRepository planRepository;
    private final ReplyRepository replyRepository;

    // 리스트 조회
    @Transactional //List<PlanAllResponseDto>원본
    public List<PlanAllResponseDto> getPlans() {

        List<Plan> planList = planRepository.findAllByOrderByCreatedAtDesc();

        List<PlanAllResponseDto> result = planList.stream()
                .map(plan -> new PlanAllResponseDto(plan, replyRepository.findAllByPlanOrderByCreatedAtDesc(plan)))
                .collect(Collectors.toList());

        return result;
    }

    /**
     * 07-12 12:23 최왕규
     *
     * 오늘의 계획만 조회
     */
    // 리스트 조회
    @Transactional
    public List<PlanAllResponseDto> getTodayPlan() {
        LocalDateTime start = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime end = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(999999999);
        List<Plan> planList = planRepository.findAllByCreatedAtBetweenOrderByCreatedAtDesc(start, end);

        List<PlanAllResponseDto> result = planList.stream()
                .map(plan -> new PlanAllResponseDto(plan, replyRepository.findAllByPlanOrderByCreatedAtDesc(plan)))
                .collect(Collectors.toList());
        return result;
    }

    /**
     *오늘이 아닌 계획 리스트 조회
     */
    @Transactional
    public List<PlanAllResponseDto> getNotTodayPlan() {

        LocalDateTime today = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        List<Plan> planList = planRepository.findAllByCreatedAtBeforeOrderByCreatedAtDesc(today);

        List<PlanAllResponseDto> result = planList.stream()
                .map(plan -> new PlanAllResponseDto(plan, replyRepository.findAllByPlanOrderByCreatedAtDesc(plan)))
                .collect(Collectors.toList());
        return result;
    }


    // 작성
    @Transactional
    public Long setPlan(PlanRequestDto planRequestDto) {
        Plan plan = new Plan(planRequestDto);
        return planRepository.save(plan).getPlanId();

    }

    // 상세페이지 조회
    @Transactional
    public PlanDetailResponseDto getPlan(Long id) {
        Plan plan = planRepository.findById(id).orElseThrow(
                () -> new ApiRequestException("해당 Plan 글이 없습니다. id = " + id));

        List<Reply> replyList = replyRepository.findAllByPlanOrderByCreatedAtDesc(plan);

        List<ReplyResponseDto> replyResponseDtoList = replyList.stream()
                .map(reply -> new ReplyResponseDto(reply))
                .collect(Collectors.toList());


        PlanDetailResponseDto responseDto = new PlanDetailResponseDto(plan, replyResponseDtoList);
        return responseDto;
    }

    // 게시글 삭제 by 2021-07-12-14:42 최민서
    @Transactional
    public Long deletePlan(Long id, DeleteRequestDto requestDto) {
        Plan plan = planRepository.findById(id).orElseThrow(
                () -> new ApiRequestException("해당 Plan 글이 없습니다. id = " + id));

        // 바말번호가 일치할때만 삭제가능
        if (!plan.getPlanPassword().equals(requestDto.getPassword())) {
            throw new ApiRequestException("비밀번호가 틀렸습니다.");
        }

        // 해당 plan와 연결되어있는 reply 먼저 삭제
        replyRepository.deleteAllByPlan(plan);
        // plan 삭제
        planRepository.deleteById(id);

        return id;
    }

    // 게시글 수정 by 2021-07-12-14:42 최민서
    @Transactional
    public Long updatePlan(Long id, PlanRequestDto requestDto) {
        Plan plan = planRepository.findById(id).orElseThrow(
                () -> new ApiRequestException("해당 Plan 글이 없습니다. id = " + id));

        // 비밀번호가 일치할때만 수정가능
        if (!plan.getPlanPassword().equals(requestDto.getPlanPassword())) {
            throw new ApiRequestException("비밀번호가 틀렸습니다.");
        }
        plan.update(requestDto);

        return id;
    }
}
