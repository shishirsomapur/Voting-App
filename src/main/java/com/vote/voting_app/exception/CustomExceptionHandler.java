package com.vote.voting_app.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vote.voting_app.constant.ErrorCodeEnum;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> handleMethodNotAllowed(HttpRequestMethodNotSupportedException ex) {

        ErrorCodeEnum errorCodeEnum = ErrorCodeEnum.METHOD_NOT_ALLOWED;

        return new ResponseEntity<>(errorCodeEnum.getMessage(), errorCodeEnum.getHttpStatus());
    }
}
