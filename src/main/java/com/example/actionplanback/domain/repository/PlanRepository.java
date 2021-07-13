package com.example.actionplanback.domain.repository;

import com.example.actionplanback.domain.entity.Plan;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {
//    List<LiveBaseballScore> findByLatestUpdateBetween(Date start, Date end);

    /**
     *
     * 2021-07-14 15:24 오늘날짜인거 가져오는거 일단완료.... by 최왕규 오늘날짜가아닌것은어케???
     */

    @Query("SELECT p FROM Plan p WHERE p.createdAt BETWEEN :start AND :end")
    List<Plan> findAllByCreatedAtBetween(LocalDateTime start, LocalDateTime end, Sort sort);



    /**
     * 07-14 20:41 오늘날짜 아닌거 가져오는거 이제시작
     */

    List<Plan> findAllByCreatedAtBefore(LocalDateTime time, Sort sort);


}
