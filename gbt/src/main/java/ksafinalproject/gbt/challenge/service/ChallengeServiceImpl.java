package ksafinalproject.gbt.challenge.service;

import ksafinalproject.gbt.challenge.model.Challenge;
import ksafinalproject.gbt.challenge.repository.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class ChallengeServiceImpl implements ChallengeService {

    private final ChallengeRepository challengeRepository;

    @Override
    public int saveChallenge(Challenge challenge) {
        log.info("save challenge : {}", challenge);
        try {
            challengeRepository.save(challenge);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public Optional<Challenge> getChallengeById(Long id) {
        log.info("get challenge by id : {}", id);
        try {
            return challengeRepository.findById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Challenge> getAllChallenge() {
        log.info("get all challenge");
        try {
            return challengeRepository.findAll();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteChallengeById(Long id) {
        log.info("delete challenge by id : {}", id);
        try {
            challengeRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
        }
    }
}
