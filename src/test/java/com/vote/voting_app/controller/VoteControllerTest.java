package com.vote.voting_app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vote.voting_app.service.interfaces.VoteService;

@ExtendWith(MockitoExtension.class)
class VoteControllerTest {

    @Mock
    private VoteService voteService;

    @InjectMocks
    private VoteController voteController;

    @Test
    void testEnterCandidate() {
        String candidateName = "John Doe";
        String responseMessage = "Candidate added successfully";

        when(voteService.enterCandidate(candidateName)).thenReturn(responseMessage);

        String result = voteController.enterCandidate(candidateName);

        assertEquals(responseMessage, result);
        verify(voteService, times(1)).enterCandidate(candidateName);
    }

    @Test
    void testCastVote() {
        String candidateName = "John Doe";
        int updatedVoteCount = 1;

        when(voteService.castVote(candidateName)).thenReturn(updatedVoteCount);

        int result = voteController.castVote(candidateName);

        assertEquals(updatedVoteCount, result);
        verify(voteService, times(1)).castVote(candidateName);
    }

    @Test
    void testCountVote() {
        String candidateName = "John Doe";
        int voteCount = 3;

        when(voteService.countVote(candidateName)).thenReturn(voteCount);

        int result = voteController.countVote(candidateName);

        assertEquals(voteCount, result);
        verify(voteService, times(1)).countVote(candidateName);
    }

    @Test
    void testListVote() {
        String voteListJson = "{\"John Doe\":3,\"Jane Doe\":5}";

        when(voteService.listVote()).thenReturn(voteListJson);

        String result = voteController.listVote();

        assertEquals(voteListJson, result);
        verify(voteService, times(1)).listVote();
    }

    @Test
    void testGetWinner() {
        String winner = "John Doe";

        when(voteService.getWinner()).thenReturn(winner);

        String result = voteController.getWinner();

        assertEquals(winner, result);
        verify(voteService, times(1)).getWinner();
    }
}

