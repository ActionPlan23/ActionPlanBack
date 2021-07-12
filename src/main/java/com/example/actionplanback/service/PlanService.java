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

        LocalDateTime localDateTime = LocalDateTime.now();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        long nano = localDateTime.getNano();

        LocalDateTime start = localDateTime.minusHours(hour).minusMinutes(minute).minusSeconds(second).minusNanos(nano);
        LocalDateTime end = localDateTime.plusHours(23-hour).plusMinutes(59-minute).plusSeconds(59-second).plusNanos(999999999-nano);
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

        LocalDateTime localDateTime = LocalDateTime.now();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        long nano = localDateTime.getNano();

        LocalDateTime start = localDateTime.minusHours(hour).minusMinutes(minute).minusSeconds(second).minusNanos(nano);
        LocalDateTime end = localDateTime.plusHours(23-hour).plusMinutes(59-minute).plusSeconds(59-second).plusNanos(999999999-nano);
        List<Plan> planList = planRepository.findAllByCreatedAtBeforeOrCreatedAtAfter(start, end);

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
