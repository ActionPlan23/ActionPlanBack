package com.example.actionplanback.domain.repository;

import com.example.actionplanback.domain.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {

}
