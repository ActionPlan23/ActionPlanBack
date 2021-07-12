package com.example.actionplanback.controller;


import com.example.actionplanback.domain.dto.PlanDetailResponseDto;
import com.example.actionplanback.domain.dto.PlanRequestDto;
import com.example.actionplanback.domain.entity.Plan;
import com.example.actionplanback.domain.repository.PlanRepository;

import com.example.actionplanback.service.PlanService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PlanController {

    private final PlanService planService;


    // 리스트 조회
    @GetMapping("/api/plan")
    public List<Plan> getPlans() {
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
}
