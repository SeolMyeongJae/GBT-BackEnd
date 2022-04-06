package ksafinalproject.gbt.userChallenge.repository;

import ksafinalproject.gbt.userChallenge.model.UserChallenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserChallengeRepository extends JpaRepository<UserChallenge, Long> {
    List<UserChallenge> findAllByUserId(Long userId);

    List<UserChallenge> findAllByChallengeId(Long challengeId);
}
