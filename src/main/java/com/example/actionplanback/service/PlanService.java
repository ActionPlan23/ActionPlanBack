package com.example.actionplanback.service;

import com.example.actionplanback.domain.dto.DeleteRequestDto;
import com.example.actionplanback.domain.dto.PlanDetailResponseDto;
import com.example.actionplanback.domain.dto.PlanRequestDto;
import com.example.actionplanback.domain.entity.Plan;
import com.example.actionplanback.domain.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public PlanDetailResponseDto getPlan(Long id) {
        Plan plan = planRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 Plan 글이 없습니다. id = " + id));
        PlanDetailResponseDto responseDto = new PlanDetailResponseDto(plan);
        return responseDto;
    }

    // 게시글 삭제 by 2021-07-12-14:42 최민서
    @Transactional
    public void deletePlan(Long id, DeleteRequestDto requestDto){
        Plan plan = planRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 Plan 글이 없습니다. id = " + id));

        // 바말번호가 일치할때만 삭제가능
        if (!plan.getPlanPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }
        planRepository.deleteById(id);
    }

    // 게시글 수정 by 2021-07-12-14:42 최민서
    @Transactional
    public void updatePlan(Long id, PlanRequestDto requestDto){
        Plan plan = planRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 Plan 글이 없습니다. id = " + id));

        // 비밀번호가 일치할때만 수정가능
        if (!plan.getPlanPassword().equals(requestDto.getPlanPassword())) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }
        plan.update(requestDto);
    }


}
