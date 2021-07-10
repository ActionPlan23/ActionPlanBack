package com.example.actionplanback.service;

import com.example.actionplanback.domain.dto.PlanRequestDto;
import com.example.actionplanback.domain.entity.Plan;
import com.example.actionplanback.domain.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PlanService {

    private final PlanRepository planRepository;


    // 리스트 조회
    @Transactional
    public List<Plan> getPlans() {
        return planRepository.findAll();
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
    public Optional<Plan> getPlan(Long id) {
        return planRepository.findById(id);
    }
}
