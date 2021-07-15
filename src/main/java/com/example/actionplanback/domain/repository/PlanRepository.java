package com.example.actionplanback.domain.repository;

import com.example.actionplanback.domain.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {

     // 오늘 날짜의 Plan 최신순 조회 by 2021-07-14 15:24 최왕규
    List<Plan> findAllByCreatedAtBetweenOrderByCreatedAtDesc(LocalDateTime start, LocalDateTime end);

     // 지난날짜의 Plan 최신순 조회 by 2021-07-14 20:41 최왕규
    List<Plan> findAllByCreatedAtBeforeOrderByCreatedAtDesc(LocalDateTime time);

     // Plan 목록 최신순 정렬 by 2021-07-14 20:41 최왕규
    List<Plan> findAllByOrderByCreatedAtDesc();
}
