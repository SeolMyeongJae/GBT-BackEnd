package ksafinalproject.gbt.userChallenge.service;

import ksafinalproject.gbt.userChallenge.model.UserChallenge;

import java.util.List;
import java.util.Optional;

public interface UserChallengeService {

    int saveUserChallenge(UserChallenge userChallenge);

    Optional<UserChallenge> getUserChallengeById(Long id);

    List<UserChallenge> getAllUserChallenge();

    void deleteUserChallengeById(Long id);

    List<UserChallenge> getAllUserChallengeByUserId(Long userid);

    List<UserChallenge> getAllUserChallengeByChallengeId(Long challengeId);
}
