package com.vote.voting_app.dao.interfaces;

public interface VoteDAO {

    String enterCandidate(String name);

    int castVote(String name);

    int countVote(String name);

    String listVote();

    String getWinner();
}
