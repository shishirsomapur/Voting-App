package com.vote.voting_app.controller;

import com.vote.voting_app.service.interfaces.VoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class VoteController {

    private VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping("/entercandidate")
    public String enterCandidate(@RequestParam String name) {

        log.info("Request received to enter a new candidate: " + name);

        log.info("calling VoteService to enter a candidate: " + name);

        String enterCandidateResponse = voteService.enterCandidate(name);

        log.info("Received response from the VoteService " + enterCandidateResponse);

        return enterCandidateResponse;

    }

    @PutMapping("/castvote")
    public int castVote(@RequestParam String name) {

        log.info("Request received to cast a vote for the candidate: " + name);

        log.info("calling VoteService to cast a vote for the candidate: " + name);

        int currentCount = voteService.castVote(name);

        log.info("Received response from VoteService " + currentCount);

        return currentCount;
    }

    @GetMapping("/countvote")
    public int countVote(@RequestParam String name) {

        log.info("Request received to count vote for the candidate: " + name);

        log.info("calling VoteService to count vote for the candidate: " + name);

        int currentCount = voteService.countVote(name);

        log.info("Received response from VoteService " + currentCount);

        return currentCount;
    }

    @GetMapping("/listvote")
    public String listVote() {

        log.info("Request received to get all the candidates and the votes with respect to them");

        log.info("calling VoteService to get all the candidates and the votes with respect to them");

        String candidateVotes = voteService.listVote();

        log.info("Received the candidates and the votes with respect to them from VoteService: {}", candidateVotes);

        return candidateVotes;
    }

    @GetMapping("/getwinner")
    public String getWinner() {

        log.info("Request received to get the candidate with the largest number of votes");

        log.info("calling VoteService to get the candidate with the largest number of votes");

        String candidateName = voteService.getWinner();

        log.info("Got the name of the candidate with the largest votes from voteService: " + candidateName);

        return candidateName;
    }
}
