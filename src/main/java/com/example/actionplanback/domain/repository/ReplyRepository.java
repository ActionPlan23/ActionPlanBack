package com.example.actionplanback.domain.repository;


import com.example.actionplanback.domain.entity.Plan;
import com.example.actionplanback.domain.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 2021-07-10 14:31 by 최왕규
 */
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findAllByPlan(Plan plan);
}
