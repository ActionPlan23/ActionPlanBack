package com.example.actionplanback.test;

import com.example.actionplanback.domain.dto.PlanRequestDto;
import com.example.actionplanback.domain.entity.Plan;
import com.example.actionplanback.domain.repository.PlanRepository;
import com.example.actionplanback.domain.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TestDataRunner implements ApplicationRunner {
    // 스프링에서처음 구동할때 이함수를 수행하게된다.
    // 테스트 데이트를 넣어준다.

    // 생성자 주입이아닌 필드주입
    // 테스트다보니까 쉽게 구현할라구

    @Autowired
    PlanRepository planRepository;

    @Autowired
    ReplyRepository replyRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 테스트 Plan 생성
        PlanRequestDto requestDto = new PlanRequestDto("테스트 제목1", "내용1", "작성자", "1234", 0L);
        Plan plan = new Plan(requestDto);
        planRepository.save(plan);

        PlanRequestDto requestDto2 = new PlanRequestDto("테스트 제목2", "내용2", "작성자", "1234", 0L);
        Plan plan2 = new Plan(requestDto2);
        planRepository.save(plan2);
    }

}