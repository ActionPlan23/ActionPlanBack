package com.example.actionplanback.controller;


import com.example.actionplanback.domain.dto.DeleteRequestDto;
import com.example.actionplanback.domain.dto.PlanAllResponseDto;
import com.example.actionplanback.domain.dto.PlanDetailResponseDto;
import com.example.actionplanback.domain.dto.PlanRequestDto;
import com.example.actionplanback.domain.entity.Plan;
import com.example.actionplanback.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RestController
public class PlanController {

    private final PlanService planService;

    // 전체조회
    @GetMapping("/api/plan")
    public List<PlanAllResponseDto> getPlans() {
        return planService.getPlans();
    }

    // 작성
    @PostMapping("/api/plan")
    public Map<String, Long> setPlan(@RequestBody PlanRequestDto planRequestDto) {

        Long planId = planService.setPlan(planRequestDto);

        Map<String, Long> createdPlanId = new HashMap<>();
        createdPlanId.put("planId", planId);
        return createdPlanId;

    }

    // 상세페이지 조회 -  || 댓글 리스트 추가 예정 ||
    @GetMapping("/api/plan/{planId}")
    public PlanDetailResponseDto getPlan(@PathVariable Long planId) {
        return planService.getPlan(planId);
    }

    // 게시글 삭제 by 2021-07-12-19:18 최민서
    @DeleteMapping("/api/plan/{planId}")
    public Map<String, Long> deletePlan(@PathVariable Long planId, @RequestBody DeleteRequestDto requestDto) {

        Long returnPlanId = planService.deletePlan(planId, requestDto);
        Map<String, Long> deletedPlanId = new HashMap<>();
        deletedPlanId.put("planId", returnPlanId);
        return deletedPlanId;
    }

    // 게시글 수정 by 2021-07-12-19:18 최민서
    @PutMapping("/api/plan/{planId}")
    public Map<String, Long> updatePlan(@PathVariable Long planId, @RequestBody PlanRequestDto requestDto) {

        Long returnPlanId = planService.updatePlan(planId, requestDto);
        Map<String, Long> updatedPlanId = new HashMap<>();
        updatedPlanId.put("planId", returnPlanId);
        return updatedPlanId;
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
