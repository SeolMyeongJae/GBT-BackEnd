package ksafinalproject.gbt.userChallenge.service;

import ksafinalproject.gbt.userChallenge.model.UserChallenge;

import java.util.List;
import java.util.Optional;

public interface UserChallengeService {

    int saveUserChallenge(UserChallenge userChallenge);

    int updateUserChallenge(UserChallenge userChallenge, Long id);

    Optional<UserChallenge> getUserChallengeById(Long id);

    List<UserChallenge> getAllUserChallenge();

    int deleteUserChallengeById(Long id);

    List<UserChallenge> getAllUserChallengeByUserId(Long userid);

    List<UserChallenge> getAllUserChallengeByChallengeId(Long challengeId);
}
