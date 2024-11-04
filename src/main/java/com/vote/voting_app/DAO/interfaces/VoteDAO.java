package com.vote.voting_app.DAO.interfaces;

public interface VoteDAO {

    public String enterCandidate(String name);

    public int castVote(String name);

}
