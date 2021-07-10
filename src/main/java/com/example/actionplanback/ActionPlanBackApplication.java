package com.example.actionplanback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ActionPlanBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActionPlanBackApplication.class, args);
    }

}
