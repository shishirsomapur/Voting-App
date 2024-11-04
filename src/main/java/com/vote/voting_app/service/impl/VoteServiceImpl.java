package com.vote.voting_app.service.impl;

import com.vote.voting_app.DAO.interfaces.VoteDAO;
import com.vote.voting_app.service.interfaces.VoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VoteServiceImpl implements VoteService {
    private VoteDAO voteDAO;

    public VoteServiceImpl(VoteDAO voteDAO) {
        this.voteDAO = voteDAO;
    }

    @Override
    public String enterCandidate(String name) {

        log.info("Request received from VoteController to enter a candidate: " + name);

        log.info("calling VoteDAO to enter a candidate: " + name);

        String enterCandidateResponse = voteDAO.enterCandidate(name);

        log.info("Received response from the VoteDAO " + enterCandidateResponse);

        return enterCandidateResponse;
    }
}
