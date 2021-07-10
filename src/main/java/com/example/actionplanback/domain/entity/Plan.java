package com.example.actionplanback.domain.entity;

import com.example.actionplanback.domain.dto.PlanRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
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
        this.title = planRequestDto.getTitle();
        this.content = planRequestDto.getContent();
        this.planWriter = planRequestDto.getPlanWriter();
        this.planPassword = planRequestDto.getPlanPassword();
        this.success = planRequestDto.getSuccess();
    }


}
