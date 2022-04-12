package ksafinalproject.gbt.challenge.service;

import ksafinalproject.gbt.challenge.dto.IChallenge;
import ksafinalproject.gbt.challenge.dto.OChallenge;
import ksafinalproject.gbt.challenge.model.Challenge;
import ksafinalproject.gbt.challenge.repository.ChallengeRepository;
import ksafinalproject.gbt.userChallenge.repository.UserChallengeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class ChallengeServiceImpl implements ChallengeService {

    private final ChallengeRepository challengeRepository;
    private final UserChallengeRepository userChallengeRepository;

    @Override
    public int saveChallenge(IChallenge iChallenge) {
        log.info("save challenge : {}", iChallenge);
        try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
//            LocalDateTime startDate = LocalDateTime.parse(iChallenge.getStartDate(), formatter);
//            LocalDateTime endDate = LocalDateTime.parse(iChallenge.getEndDate(), formatter);
            challengeRepository.save(Challenge.builder()
                    .id(iChallenge.getId())
                    .startDate(iChallenge.getStartDate())
                    .endDate(iChallenge.getEndDate())
                    .method(iChallenge.getMethod())
                    .title(iChallenge.getTitle())
                    .frequency(iChallenge.getFrequency())
                    .summary(iChallenge.getSummary())
                    .description(iChallenge.getDescription())
                    .max(iChallenge.getMax())
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
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
//        LocalDateTime startDate = LocalDateTime.parse(iChallenge.getStartDate(), formatter);
//        LocalDateTime endDate = LocalDateTime.parse(iChallenge.getEndDate(), formatter);
        try {
            if (challengeRepository.findById(id).isEmpty()) {
                return -1;
            }
            Challenge challenge = challengeRepository.findById(id).orElseThrow();
            challenge.setStartDate(iChallenge.getStartDate());
            challenge.setEndDate(iChallenge.getEndDate());
            challenge.setTitle(iChallenge.getTitle());
            challenge.setFrequency(iChallenge.getFrequency());
            challenge.setDescription(iChallenge.getDescription());
            challenge.setSummary(iChallenge.getSummary());
            challenge.setMax(iChallenge.getMax());
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public Optional<OChallenge> getChallengeById(Long id) {
        log.info("find challenge by id : {}", id);
        try {
            Optional<Challenge> challenge = challengeRepository.findById(id);
            OChallenge oChallenge = new OChallenge();
            Long current = userChallengeRepository.countByChallengeId(challenge.orElseThrow().getId());
            oChallenge.setId(challenge.orElseThrow().getId());
            oChallenge.setTitle(challenge.orElseThrow().getTitle());
            oChallenge.setStartDate(challenge.orElseThrow().getStartDate());
            oChallenge.setEndDate(challenge.orElseThrow().getEndDate());
            oChallenge.setMethod(challenge.orElseThrow().getMethod());
            oChallenge.setFrequency(challenge.orElseThrow().getFrequency());
            oChallenge.setDescription(challenge.orElseThrow().getDescription());
            oChallenge.setSummary(challenge.orElseThrow().getSummary());
            oChallenge.setCurrent(current);
            oChallenge.setMax(challenge.orElseThrow().getMax());
            oChallenge.setChallengeImg(challenge.orElseThrow().getChallengeImg());
            return Optional.of(oChallenge);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<OChallenge> getAllChallenge() {
        log.info("find all challenge");
        try {
            List<Challenge> challengeList = challengeRepository.findAll();
            List<OChallenge> oChallenge = new ArrayList<>();
            for (Challenge challenge : challengeList) {
                Long current = userChallengeRepository.countByChallengeId(challenge.getId());
                oChallenge.add(OChallenge.builder()
                        .id(challenge.getId())
                        .title(challenge.getTitle())
                        .startDate(challenge.getStartDate())
                        .endDate(challenge.getEndDate())
                        .method(challenge.getMethod())
                        .frequency(challenge.getFrequency())
                        .summary(challenge.getSummary())
                        .description(challenge.getDescription())
                        .current(current)
                        .max(challenge.getMax())
                        .challengeImg(challenge.getChallengeImg())
                        .build());
            }
            return oChallenge;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<OChallenge> getAllChallengeIncludeUserId(Long userId) {
        log.info("find all challenge include user id : {}", userId);
        try {
            List<Challenge> challengeList = challengeRepository.findAll();
            List<OChallenge> oChallenge = new ArrayList<>();
            for (Challenge challenge : challengeList) {
                Long current = userChallengeRepository.countByChallengeId(challenge.getId());
                oChallenge.add(OChallenge.builder()
                        .id(challenge.getId())
                        .title(challenge.getTitle())
                        .startDate(challenge.getStartDate())
                        .endDate(challenge.getEndDate())
                        .method(challenge.getMethod())
                        .frequency(challenge.getFrequency())
                        .summary(challenge.getSummary())
                        .description(challenge.getDescription())
                        .isJoin(userChallengeRepository.existsByUserIdAndChallengeId(userId, challenge.getId()))
                        .current(current)
                        .max(challenge.getMax())
                        .challengeImg(challenge.getChallengeImg())
                        .build());
            }
            return oChallenge;
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
