package com.example.actionplanback.controller;


import com.example.actionplanback.domain.dto.DeleteRequestDto;
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

    // 게시글 삭제 by 2021-07-12-14:18 최민서
    @DeleteMapping("/api/plan/{planId}")
    public void deletePlan(@PathVariable Long planId, @RequestBody DeleteRequestDto requestDto){
        planService.deletePlan(planId, requestDto);
    }

    // 게시글 수정 by 2021-07-12-14:18 최민서
    @PutMapping("/api/plan/{planId}")
    public void updatePlan(@PathVariable Long planId, @RequestBody PlanRequestDto requestDto){
        planService.updatePlan(planId, requestDto);
    }

}
