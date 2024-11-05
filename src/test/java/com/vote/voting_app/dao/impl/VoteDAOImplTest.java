package com.vote.voting_app.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.Gson;
import com.vote.voting_app.exception.CandidateNotFoundException;

@ExtendWith(MockitoExtension.class)
class VoteDAOImplTest {

    private Gson gson;

    @InjectMocks
    private VoteDAOImpl voteDAO;

    @BeforeEach
    void setUp() {
        gson = new Gson();
        voteDAO = new VoteDAOImpl(gson);
    }


    private HashMap<String, Integer> getVoteMap() throws NoSuchFieldException, IllegalAccessException {
        Field voteMapField = VoteDAOImpl.class.getDeclaredField("voteMap");
        voteMapField.setAccessible(true);
        return (HashMap<String, Integer>) voteMapField.get(voteDAO);
    }

    @Test
    public void testEnterCandidate_Success() throws Exception {
        String response = voteDAO.enterCandidate("Alice");

        assertEquals("Added the candidate successfully: Alice with initial vote count of 0", response);
        assertTrue(getVoteMap().containsKey("Alice"));
    }

    @Test
    public void testEnterCandidate_AlreadyExists() throws Exception {
        voteDAO.enterCandidate("Alice");
        String response = voteDAO.enterCandidate("Alice");

        assertEquals("The candidate Alice is already present.", response);
    }

    @Test
    public void testCastVote_CandidateNotFound() {
        assertThrows(CandidateNotFoundException.class, () -> voteDAO.castVote("NonExistent"));
    }

    @Test
    public void testCastVote_Success() throws Exception {
        voteDAO.enterCandidate("Bob");
        int count = voteDAO.castVote("Bob");

        assertEquals(1, count);
        assertEquals(1, getVoteMap().get("Bob"));
    }

    @Test
    public void testCountVote_Success() throws Exception {
        voteDAO.enterCandidate("Charlie");
        voteDAO.castVote("Charlie");
        voteDAO.castVote("Charlie");

        int count = voteDAO.countVote("Charlie");
        assertEquals(2, count);
    }

    @Test
    public void testCountVote_CandidateNotFound() {
        assertThrows(CandidateNotFoundException.class, () -> voteDAO.countVote("NonExistent"));
    }

    @Test
    public void testListVote_NoCandidates() {
        String response = voteDAO.listVote();
        assertEquals("No candidates are present in the voting list.", response);
    }

    @Test
    public void testListVote_WithCandidates() throws Exception {
        voteDAO.enterCandidate("Alice");
        voteDAO.castVote("Alice");

        String expectedJson = "{\"Alice\":1}";

        String actualJson = voteDAO.listVote();
        System.out.println("Actual JSON from listVote: " + actualJson);

        assertEquals(expectedJson, actualJson);
    }


    @Test
    public void testGetWinner_NoCandidates() {
        String response = voteDAO.getWinner();
        assertEquals("No candidates are present in the voting list.", response);
    }

    @Test
    public void testGetWinner_WithCandidates() throws Exception {
        voteDAO.enterCandidate("Alice");
        voteDAO.enterCandidate("Bob");
        voteDAO.castVote("Alice");
        voteDAO.castVote("Alice");
        voteDAO.castVote("Bob");

        String winner = voteDAO.getWinner();
        assertEquals("Alice", winner);
    }
}

