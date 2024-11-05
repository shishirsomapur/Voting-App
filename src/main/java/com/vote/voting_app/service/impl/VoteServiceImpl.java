package com.vote.voting_app.service.impl;

import com.vote.voting_app.dao.interfaces.VoteDAO;
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

    @Override
    public int castVote(String name) {

        log.info("Request received from VoteController to cast vote for a candidate: " + name);

        log.info("calling VoteDAO to cast vote for a candidate: " + name);

        int currentCount = voteDAO.castVote(name);

        log.info("Received response from VoteDAO " + currentCount);

        return currentCount;
    }

    @Override
    public int countVote(String name) {

        log.info("Request received from VoteController to count the vote for the candidate: " + name);

        log.info("calling VoteDAO to count vote for the candidate: " + name);

        int currentCount = voteDAO.countVote(name);

        log.info("Received response from VoteDAO " + currentCount);

        return currentCount;
    }

    @Override
    public String listVote() {

        log.info("Request received from VoteController to get all the candidates and the votes with respect to them ");

        log.info("calling VoteDAO to get all the candidates and the votes with respect to them ");

        String candidateVotes = voteDAO.listVote();

        log.info("Received the candidates and the votes with respect to them from VoteDAO: " + candidateVotes);

        return candidateVotes;
    }

    @Override
    public String getWinner() {

        log.info("Request received to get the candidate with the largest number of votes");

        log.info("calling VoteDAO to get the candidate with the largest number of votes ");

        String candidateName = voteDAO.getWinner();

        log.info("Got the name of the candidate with the largest votes from voteDAO: " + candidateName);

        return candidateName;
    }
}
