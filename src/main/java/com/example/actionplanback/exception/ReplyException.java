package com.example.actionplanback.exception;

public class ReplyException extends RuntimeException {
    private static final String message = "해당 댓글을 찾을 수 없습니다.";
    public ReplyException() {
        super(message);
    }
}
