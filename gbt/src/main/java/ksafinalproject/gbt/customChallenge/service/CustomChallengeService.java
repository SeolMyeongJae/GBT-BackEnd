package ksafinalproject.gbt.customChallenge.service;

import ksafinalproject.gbt.customChallenge.dto.ICustomChallenge;
import ksafinalproject.gbt.customChallenge.model.CustomChallenge;

import java.util.List;
import java.util.Optional;

public interface CustomChallengeService {
    int saveCustomChallenge(ICustomChallenge icustomChallenge);

    int updateCustomChallenge(ICustomChallenge iCustomChallenge, Long id);

    Optional<CustomChallenge> getCustomChallengeById(Long id);

    List<CustomChallenge> getAllCustomChallenge();

    List<CustomChallenge> getAllCustomChallengeByCreatorId(Long creatorId);

    void deleteCustomChallengeById(Long id);
}
