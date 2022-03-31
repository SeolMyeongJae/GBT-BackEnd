package ksafinalproject.gbt.challenge.service;

import ksafinalproject.gbt.challenge.dto.IChallenge;
import ksafinalproject.gbt.challenge.model.Challenge;
import ksafinalproject.gbt.challenge.repository.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class ChallengeServiceImpl implements ChallengeService {

    private final ChallengeRepository challengeRepository;

    @Override
    public int saveChallenge(IChallenge iChallenge) {
        log.info("save challenge : {}", iChallenge);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
            LocalDateTime startDate = LocalDateTime.parse(iChallenge.getStartDate(), formatter);
            LocalDateTime endDate = LocalDateTime.parse(iChallenge.getEndDate(), formatter);
            challengeRepository.save(Challenge.builder()
                    .id(iChallenge.getId())
                    .startDate(startDate)
                    .endDate(endDate)
                    .method(iChallenge.getMethod())
                    .title(iChallenge.getTitle())
                    .frequency(iChallenge.getFrequency())
                    .description(iChallenge.getDescription())
                    .max(iChallenge.getMax())
                    .img(iChallenge.getImg())
                    .build());
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    @Transactional
    public int updateChallenge(IChallenge iChallenge, Long id) {
        log.info("update challenge : {}, id : {}", iChallenge, id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
        LocalDateTime startDate = LocalDateTime.parse(iChallenge.getStartDate(), formatter);
        LocalDateTime endDate = LocalDateTime.parse(iChallenge.getEndDate(), formatter);
        try {
            if (challengeRepository.findById(id).isEmpty()) {
                return -1;
            }
            Challenge challenge = challengeRepository.findById(id).orElseThrow();
            challenge.setStartDate(startDate);
            challenge.setEndDate(endDate);
            challenge.setTitle(iChallenge.getTitle());
            challenge.setFrequency(iChallenge.getFrequency());
            challenge.setDescription(iChallenge.getDescription());
            challenge.setMax(iChallenge.getMax());
            challenge.setImg(iChallenge.getImg());
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
    public int deleteChallengeById(Long id) {
        log.info("delete challenge by id : {}", id);
        try {
            challengeRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }
}
