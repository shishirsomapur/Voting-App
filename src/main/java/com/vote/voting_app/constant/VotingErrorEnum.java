package com.vote.voting_app.constant;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum VotingErrorEnum {

    CANDIDATE_NOT_FOUND("Candidate not found", HttpStatus.NOT_FOUND);

    private final String message;
    private final HttpStatus httpStatus;

}
