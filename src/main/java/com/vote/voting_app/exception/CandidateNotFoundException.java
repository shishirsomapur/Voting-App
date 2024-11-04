package com.vote.voting_app.exception;

import org.springframework.http.HttpStatus;

import com.vote.voting_app.constant.ErrorCodeEnum;

public class CandidateNotFoundException extends RuntimeException {

    private final ErrorCodeEnum errorCodeEnum;

    public CandidateNotFoundException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.errorCodeEnum = errorCodeEnum;
    }

    public HttpStatus getHttpStatus() {
        return errorCodeEnum.getHttpStatus();
    }

}
