package com.example.actionplanback.service;

import com.example.actionplanback.domain.dto.PlanAllResponseDto;
import com.example.actionplanback.domain.dto.PlanDetailResponseDto;
import com.example.actionplanback.domain.dto.PlanRequestDto;
import com.example.actionplanback.domain.entity.Plan;
import com.example.actionplanback.domain.repository.PlanRepository;
import com.example.actionplanback.domain.repository.ReplyRepository;
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
    @Transactional
    public List<PlanAllResponseDto> getPlans() {
        List<Plan> planList = planRepository.findAll();


        List<PlanAllResponseDto> result = planList.stream().
                map(plan -> new PlanAllResponseDto(plan))
                .collect(Collectors.toList());
        return result;
    }

    /**
     *
     * 오늘의 계획만 조회
     */
    // 리스트 조회
    @Transactional
    public List<PlanAllResponseDto> getTodayPlan() {
        LocalDateTime start = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime end = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(999999999);
        List<Plan> planList = planRepository.findAllByCreatedAtBetween(start, end);

        List<PlanAllResponseDto> result = planList.stream().
                map(plan -> new PlanAllResponseDto(plan))
                .collect(Collectors.toList());
        return result;
    }

    /**
     *오늘이 아닌 계획 리스트 조회
     */
    @Transactional
    public List<PlanAllResponseDto> getNotTodayPlan() {

        LocalDateTime today = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        List<Plan> planList = planRepository.findAllByCreatedAtBefore(today);

        List<PlanAllResponseDto> result = planList.stream().
                map(plan -> new PlanAllResponseDto(plan))
                .collect(Collectors.toList());
        return result;
    }



    // 작성
    @Transactional
    public Plan setPlan(PlanRequestDto planRequestDto) {
        Plan plan = new Plan(planRequestDto);
        planRepository.save(plan);
        return plan;
    }

    // 상세페이지 조회
    @Transactional
    public PlanDetailResponseDto getPlan(Long id) {
        Plan plan = planRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 Plan 글이 없습니다. id = "+id));
        PlanDetailResponseDto responseDto = new PlanDetailResponseDto(plan);
        return responseDto;
    }
}
