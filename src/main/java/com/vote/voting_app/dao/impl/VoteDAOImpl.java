package com.vote.voting_app.dao.impl;

import com.google.gson.Gson;
import com.vote.voting_app.dao.interfaces.VoteDAO;
import com.vote.voting_app.constant.ErrorCodeEnum;
import com.vote.voting_app.exception.CandidateNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
@Slf4j
public class VoteDAOImpl implements VoteDAO {

    private HashMap<String, Integer> voteMap = new HashMap<>();

    private Gson gson;

    public VoteDAOImpl(Gson gson) {
        this.gson = gson;
    }

    @Override
    public String enterCandidate(String name) {

        log.info("Request received from VoteService to enter a candidate: " + name);

        if (voteMap.containsKey(name)) {

            log.info("The candidate " + name + " is already present.");

            return "The candidate " + name + " is already present.";
        }

        voteMap.put(name, 0);

        log.info("Added the candidate successfully: " + name + " with initial vote count of " + voteMap.get(name));

        return "Added the candidate successfully: " + name + " with initial vote count of " + voteMap.get(name);

    }

    @Override
    public int castVote(String name) {

        log.info("Request received from VoteService to cast vote for a candidate: " + name);

        if(!voteMap.containsKey(name)) {

            throw new CandidateNotFoundException(ErrorCodeEnum.CANDIDATE_NOT_FOUND);
        }

        voteMap.put(name, voteMap.get(name) + 1);

        log.info("Casted vote for the candidate " + name + " and his current count is " + voteMap.get(name));

        return voteMap.get(name);

    }

    @Override
    public int countVote(String name) {

        log.info("Request received from VoteService to count vote for the candidate: " + name);

        if(!voteMap.containsKey(name)) {

            throw new CandidateNotFoundException(ErrorCodeEnum.CANDIDATE_NOT_FOUND);
        }

        log.info("The number of votes for the candidate " + name + " is " + voteMap.get(name) );

        return voteMap.get(name);
    }

    @Override
    public String listVote() {

        String voteMapJson;

        log.info("Request received from VoteService to get all the candidates and the votes with respect to them ");

        if(voteMap.isEmpty()) {

            log.info("No candidates are present in the voting list.");

            return "No candidates are present in the voting list.";
        }

        voteMapJson = gson.toJson(voteMap);

        log.info("The candidates and the votes with respect to them are " + voteMapJson);

        return voteMapJson;
    }

    @Override
    public String getWinner() {

        String candidateName = null;
        int maxVotes = -1;

        if(voteMap.isEmpty()) {

            log.info("No candidates are present in the voting list.");

            return "No candidates are present in the voting list.";
        }

        log.info("Request received from VoteService to get the candidate with the largest votes");

        for(Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            if(entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                candidateName = entry.getKey();
            }
        }

        log.info("Got the name of the candidate with the largest votes: " + candidateName);

        return candidateName;
    }
}
