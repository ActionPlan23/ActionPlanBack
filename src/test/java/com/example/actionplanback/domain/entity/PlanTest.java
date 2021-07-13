package com.example.actionplanback.domain.entity;

import com.example.actionplanback.domain.dto.PlanRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanTest {
    @Test
    @DisplayName("PLAN - 정상")
    void setPlan() {
        // given
        Long planId = 100L;
        String title = "title_test";
        String content = "content_test";
        String planWriter = "planWriter_test";
        String planPassword = "planPassword_test";

        PlanRequestDto planRequestDto = new PlanRequestDto(
                title,
                content,
                planWriter,
                planPassword
        );

        // when
        Plan plan = new Plan(planRequestDto);

        // then
        assertNull(plan.getPlanId());
        assertEquals(title, plan.getTitle());
        assertEquals(content, plan.getContent());
        assertEquals(planWriter, plan.getPlanWriter());
        assertEquals(planPassword, plan.getPlanPassword());
    }

}
