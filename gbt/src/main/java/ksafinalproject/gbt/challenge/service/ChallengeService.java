package ksafinalproject.gbt.challenge.service;

import ksafinalproject.gbt.challenge.model.Challenge;

import java.util.List;
import java.util.Optional;

public interface ChallengeService {
    int saveChallenge(Challenge challenge);

    Optional<Challenge> getChallengeById(Long id);

    List<Challenge> getAllChallenge();

    void deleteChallengeById(Long id);

}
