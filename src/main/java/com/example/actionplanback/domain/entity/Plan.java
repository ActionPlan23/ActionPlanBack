package com.example.actionplanback.domain.entity;

import com.example.actionplanback.domain.dto.PlanRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Plan extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long planId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String planWriter;

    @Column(nullable = false)
    private String planPassword;

    @Column(nullable = false)
    private Long success;


    public Plan(PlanRequestDto planRequestDto) {
        checkEmptyPlan(planRequestDto);

        this.title = planRequestDto.getTitle();
        this.content = planRequestDto.getContent();
        this.planWriter = planRequestDto.getPlanWriter();
        this.planPassword = planRequestDto.getPlanPassword();
        this.success = planRequestDto.getSuccess();
    }

    // Plan 수정 by 2021-07-12-19:18 최민서
    public void update(PlanRequestDto planRequestDto) {
        checkTitleContent(planRequestDto);

        this.title = planRequestDto.getTitle();
        this.content = planRequestDto.getContent();
    }

    // 제목과 내용이 비었는지 확인 by 2021-07-12-19:18 최민서
    public void checkTitleContent(PlanRequestDto planRequestDto) {
        if (planRequestDto.getTitle() == null || planRequestDto.getTitle().isEmpty()) {
            throw new IllegalArgumentException("제목을 입력해주세요.");
        }
        if (planRequestDto.getContent() == null || planRequestDto.getContent().isEmpty()) {
            throw new IllegalArgumentException("내용을 입력해주세요.");
        }
    }

    // 처음 Plan 작성시 빈 필드가 있는지 확인 by 2021-07-12-19:18 최민서
    public void checkEmptyPlan(PlanRequestDto planRequestDto) {
        checkTitleContent(planRequestDto);

        if (planRequestDto.getPlanWriter() == null || planRequestDto.getPlanWriter().isEmpty()) {
            throw new IllegalArgumentException("작성자 이름을 입력해주세요.");
        }
        if (planRequestDto.getPlanPassword() == null || planRequestDto.getPlanPassword().isEmpty()) {
            throw new IllegalArgumentException("비밀번호를 입력해주세요.");
        }
    }

}
