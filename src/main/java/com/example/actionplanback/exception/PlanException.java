package com.example.actionplanback.exception;


public class PlanException extends RuntimeException {
    private static final String message = "해당 게시물이 존재하지 않습니다.";
    public PlanException() {
        super(message);
    }
}
