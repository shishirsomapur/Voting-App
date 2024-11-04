package com.vote.voting_app.service.interfaces;

public interface VoteService {

    String enterCandidate(String name);

    int castVote(String name);

    int countVote(String name);

    String listVote();
}
