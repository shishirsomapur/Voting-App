package com.vote.voting_app.exception;

import org.springframework.http.HttpStatus;

import com.vote.voting_app.constant.VotingErrorEnum;

public class CandidateNotFoundException extends RuntimeException {

    private final VotingErrorEnum votingErrorEnum;

    public CandidateNotFoundException(VotingErrorEnum votingErrorEnum) {
        super(votingErrorEnum.getMessage());
        this.votingErrorEnum = votingErrorEnum;
    }

    public HttpStatus getHttpStatus() {
        return votingErrorEnum.getHttpStatus();
    }

}
