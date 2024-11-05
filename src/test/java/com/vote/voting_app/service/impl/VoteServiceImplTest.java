package com.vote.voting_app.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vote.voting_app.dao.interfaces.VoteDAO;

@ExtendWith(MockitoExtension.class)
class VoteServiceImplTest {

    @Mock
    private VoteDAO voteDAO;

    @InjectMocks
    private VoteServiceImpl voteService;

    @Test
    void testEnterCandidate() {
        String candidateName = "John Doe";
        String responseMessage = "Candidate added successfully";

        when(voteDAO.enterCandidate(candidateName)).thenReturn(responseMessage);

        String result = voteService.enterCandidate(candidateName);

        assertEquals(responseMessage, result);
        verify(voteDAO, times(1)).enterCandidate(candidateName);
    }

    @Test
    void testCastVote() {
        String candidateName = "John Doe";
        int updatedVoteCount = 1;

        when(voteDAO.castVote(candidateName)).thenReturn(updatedVoteCount);

        int result = voteService.castVote(candidateName);

        assertEquals(updatedVoteCount, result);
        verify(voteDAO, times(1)).castVote(candidateName);
    }

    @Test
    void testCountVote() {
        String candidateName = "John Doe";
        int voteCount = 3;

        when(voteDAO.countVote(candidateName)).thenReturn(voteCount);

        int result = voteService.countVote(candidateName);

        assertEquals(voteCount, result);
        verify(voteDAO, times(1)).countVote(candidateName);
    }

    @Test
    void testListVote() {
        String voteListJson = "{\"John Doe\":3,\"Jane Doe\":5}";

        when(voteDAO.listVote()).thenReturn(voteListJson);

        String result = voteService.listVote();

        assertEquals(voteListJson, result);
        verify(voteDAO, times(1)).listVote();
    }

    @Test
    void testGetWinner() {
        String winner = "John Doe";

        when(voteDAO.getWinner()).thenReturn(winner);

        String result = voteService.getWinner();

        assertEquals(winner, result);
        verify(voteDAO, times(1)).getWinner();
    }
}
