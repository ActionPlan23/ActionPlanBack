package com.example.actionplanback.controller;


import com.example.actionplanback.domain.dto.PlanAllResponseDto;
import com.example.actionplanback.domain.dto.PlanDetailResponseDto;
import com.example.actionplanback.domain.dto.PlanRequestDto;
import com.example.actionplanback.domain.entity.Plan;

import com.example.actionplanback.service.PlanService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PlanController {

    private final PlanService planService;


    // 리스트 조회
    @GetMapping("/api/plan")
    public List<PlanAllResponseDto> getPlans() {
        return planService.getPlans();
    }

    // 작성
    @PostMapping("/api/plan")
    public Plan setPlan(@RequestBody PlanRequestDto planRequestDto) {
        Plan plan = planService.setPlan(planRequestDto);
        return plan;
    }

    // 상세페이지 조회 -  || 댓글 리스트 추가 예정 ||
    @GetMapping("/api/plan/{planId}")
    public PlanDetailResponseDto getPlan(@PathVariable Long planId) {
        return planService.getPlan(planId);
    }


    /**
     * 07-12 19:37 오늘계획날짜 오늘아닌날짜 가져오는 GetMapping 작성 by 최왕규
     */

    @GetMapping("/api/todayplan")
    public List<PlanAllResponseDto> getTodayPlan(){
        return planService.getTodayPlan();
    }


    @GetMapping("/api/pastplan")
    public List<PlanAllResponseDto> getPastPlan(){
        return planService.getNotTodayPlan();
    }

}
