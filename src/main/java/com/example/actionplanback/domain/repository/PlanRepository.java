package com.example.actionplanback.domain.repository;

import com.example.actionplanback.domain.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {
//    List<LiveBaseballScore> findByLatestUpdateBetween(Date start, Date end);

    /**
     *
     * 2021-07-14 15:24 오늘날짜인거 가져오는거 일단완료.... by 최왕규 오늘날짜가아닌것은어케???
     */
    List<Plan> findAllByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

    /**
     * 07-14 19:23 오늘날짜 아닌거 가져오는거 이제시작
     */
    List<Plan> findAllByCreatedAtBeforeOrCreatedAtAfter(LocalDateTime start, LocalDateTime end);


}
