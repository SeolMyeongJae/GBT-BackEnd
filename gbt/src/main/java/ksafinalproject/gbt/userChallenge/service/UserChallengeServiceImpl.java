package ksafinalproject.gbt.userChallenge.service;

import ksafinalproject.gbt.userChallenge.model.UserChallenge;
import ksafinalproject.gbt.userChallenge.repository.UserChallengeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserChallengeServiceImpl implements UserChallengeService {

    private final UserChallengeRepository userChallengeRepository;

    @Override
    public int saveUserChallenge(UserChallenge userChallenge) {
        log.info("save user challenge : {}", userChallenge);
        try {
            userChallengeRepository.save(userChallenge);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Transactional
    @Override
    public int updateUserChallenge(UserChallenge userChallenge, Long id) {
        log.info("update user challenge : {}, id : {}", userChallenge, id);
        try {
            UserChallenge userChallenge2 = userChallengeRepository.findById(id).orElseThrow();
            userChallenge2.setChallengeId(userChallenge.getChallengeId());
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public Optional<UserChallenge> getUserChallengeById(Long id) {
        log.info("find user challenge by id : {}", id);
        try {
            return userChallengeRepository.findById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<UserChallenge> getAllUserChallenge() {
        log.info("find all user challenge");
        try {
            return userChallengeRepository.findAll();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public int deleteUserChallengeById(Long id) {
        log.info("delete user challenge by id : {} ", id);
        try {
            userChallengeRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public List<UserChallenge> getAllUserChallengeByUserId(Long userid) {
        log.info("find all user challenge by user id : {}", userid);
        try {
            return userChallengeRepository.findAllByUserId(userid);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<UserChallenge> getAllUserChallengeByChallengeId(Long challengeId) {
        log.info("find all user challenge by challenge id : {}", challengeId);
        try {
            return userChallengeRepository.findAllByChallengeId(challengeId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}
