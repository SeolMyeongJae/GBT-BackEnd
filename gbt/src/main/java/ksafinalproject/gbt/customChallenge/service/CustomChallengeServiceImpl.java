package ksafinalproject.gbt.customChallenge.service;

import ksafinalproject.gbt.customChallenge.model.CustomChallenge;
import ksafinalproject.gbt.customChallenge.repository.CustomChallengeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class CustomChallengeServiceImpl implements CustomChallengeService{

    private final CustomChallengeRepository customChallengeRepository;

    @Override
    public int saveCustomChallenge(CustomChallenge customChallenge) {
        log.info("save custom challenge : {}", customChallenge);
        try {
            customChallengeRepository.save(customChallenge);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return 2;
        }
    }

    @Override
    public Optional<CustomChallenge> getCustomChallengeById(Long id) {
        log.info("find custom challenge by id : {}", id);
        try {
            return customChallengeRepository.findById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<CustomChallenge> getAllCustomChallenge() {
        log.info("find all custom challenge");
        try {
            return customChallengeRepository.findAll();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteCustomChallengeById(Long id) {
        log.info("delete custom challenge by id : {}", id);
        try {
            customChallengeRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
        }
    }
}
