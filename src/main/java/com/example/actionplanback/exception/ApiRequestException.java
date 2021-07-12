package com.example.actionplanback.exception;

/**
 * 2021-07-12 14:19 by 최민서
 */
public class ApiRequestException extends IllegalArgumentException {

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}