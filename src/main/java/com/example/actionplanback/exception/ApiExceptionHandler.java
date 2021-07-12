package com.example.actionplanback.exception;

import com.example.actionplanback.domain.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PlanException.class)
    public ErrorResponseDto planNotFound(PlanException p_ex) {
       return ErrorResponseDto.of(HttpStatus.BAD_REQUEST, p_ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ReplyException.class)
    public ErrorResponseDto replyNotFound(ReplyException r_ex) {
        return ErrorResponseDto.of(HttpStatus.BAD_REQUEST, r_ex.getMessage());
    }
}
