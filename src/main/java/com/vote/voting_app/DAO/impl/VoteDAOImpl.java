package com.vote.voting_app.DAO.impl;

import com.google.gson.Gson;
import com.vote.voting_app.DAO.interfaces.VoteDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;


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

}
