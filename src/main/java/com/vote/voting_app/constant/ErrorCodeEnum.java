package com.vote.voting_app.constant;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    CANDIDATE_NOT_FOUND("Candidate not found", HttpStatus.NOT_FOUND),
    METHOD_NOT_ALLOWED("Method not allowed for this endpoint. Please use the correct HTTP method.", HttpStatus.METHOD_NOT_ALLOWED);

    private final String message;
    private final HttpStatus httpStatus;

}
