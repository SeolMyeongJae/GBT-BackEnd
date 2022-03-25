package ksafinalproject.gbt.customChallenge.service;

import ksafinalproject.gbt.customChallenge.model.CustomChallenge;

import java.util.List;
import java.util.Optional;

public interface CustomChallengeService {
    int saveCustomChallenge(CustomChallenge customChallenge);

    Optional<CustomChallenge> getCustomChallengeById(Long id);

    List<CustomChallenge> getAllCustomChallenge();

    void deleteCustomChallengeById(Long id);
}
