package ksafinalproject.gbt.userChallenge.service;

import ksafinalproject.gbt.userChallenge.dto.IUserChallenge;
import ksafinalproject.gbt.userChallenge.model.UserChallenge;

import java.util.List;
import java.util.Optional;

public interface UserChallengeService {

    int saveUserChallenge(IUserChallenge iUserChallenge);

    int updateUserChallenge(IUserChallenge iUserChallenge, Long id);

    Optional<UserChallenge> getUserChallengeById(Long id);

    List<UserChallenge> getAllUserChallenge();

    int deleteUserChallengeById(Long id);

    List<UserChallenge> getAllUserChallengeByUserId(Long userid);

    List<UserChallenge> getAllUserChallengeByChallengeId(Long challengeId);
}
