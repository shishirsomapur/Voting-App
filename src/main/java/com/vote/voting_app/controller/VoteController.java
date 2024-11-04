package com.vote.voting_app.controller;

import com.vote.voting_app.service.interfaces.VoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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

    @GetMapping("/castvote")
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
}
