package com.example.actionplanback.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;


@AllArgsConstructor
@Getter
public class ErrorResponseDto {
    private final int code;
    private final String message;

    public static ErrorResponseDto of (HttpStatus httpStatus, String errorMessage) {
        return new ErrorResponseDto(httpStatus.value(), errorMessage);
    }
    public static ErrorResponseDto of (HttpStatus httpStatus, FieldError fieldError) {
        if (fieldError != null) {
            return new ErrorResponseDto(httpStatus.value(), fieldError.getDefaultMessage());
        }
        return new ErrorResponseDto(httpStatus.value(), "유효한 값이 아닙니다.");
    }
}
