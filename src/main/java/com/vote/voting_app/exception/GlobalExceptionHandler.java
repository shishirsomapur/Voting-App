package com.vote.voting_app.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vote.voting_app.exception.CandidateNotFoundException;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CandidateNotFoundException.class)
    public ResponseEntity<String> handleCandidateNotFound(CandidateNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.getHttpStatus());
    }

}
