package com.example.actionplanback.domain.entity;

import com.example.actionplanback.domain.dto.PlanRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    // plan에 대해서 mapping이 되어진 아이야.
    // 나는 단순히 읽기만 할 수 있어
    @OneToMany(mappedBy = "plan", fetch = FetchType.EAGER)
    private List<Reply> replyList = new ArrayList<>();

    public Plan(PlanRequestDto planRequestDto) {

        if (planRequestDto.getTitle() == null || planRequestDto.getTitle().isEmpty()) {
            throw new IllegalArgumentException("제목을 입력해주세요.");
        }
        if (planRequestDto.getContent() == null || planRequestDto.getContent().isEmpty()) {
            throw new IllegalArgumentException("내용을 입력해주세요.");
        }
        if (planRequestDto.getPlanWriter() == null || planRequestDto.getPlanWriter().isEmpty()) {
            throw new IllegalArgumentException("작성자 이름을 입력해주세요.");
        }
        if (planRequestDto.getPlanPassword() == null || planRequestDto.getPlanPassword().isEmpty()) {
            throw new IllegalArgumentException("비밀번호를 입력해주세요.");
        }


        this.title = planRequestDto.getTitle();
        this.content = planRequestDto.getContent();
        this.planWriter = planRequestDto.getPlanWriter();
        this.planPassword = planRequestDto.getPlanPassword();
        this.success = planRequestDto.getSuccess();
    }


}
