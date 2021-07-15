package com.example.actionplanback.domain.repository;


import com.example.actionplanback.domain.entity.Plan;
import com.example.actionplanback.domain.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 2021-07-10 14:31 by 최왕규
 */
public interface ReplyRepository extends JpaRepository<Reply, Long> {

    // 해당 Plan 과 연관되어 있는 Reply 삭제
    void deleteAllByPlan(Plan plan);

    // 해당 Plan 과 연관된 Reply 최신순 정렬 조회
    List<Reply> findAllByPlanOrderByCreatedAtDesc(Plan plan);
}
