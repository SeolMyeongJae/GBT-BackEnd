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
                    .summary(iChallenge.getSummary())
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
            challenge.setSummary(iChallenge.getSummary());
            challenge.setMax(iChallenge.getMax());
            challenge.setImg(iChallenge.getImg());
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
            oChallenge.setImg(challenge.orElseThrow().getImg());
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
            for (int i = 0; i < challengeList.size(); i++) {
                Long current = userChallengeRepository.countByChallengeId(challengeList.get(i).getId());
                oChallenge.add(OChallenge.builder()
                        .id(challengeList.get(i).getId())
                        .title(challengeList.get(i).getTitle())
                        .startDate(challengeList.get(i).getStartDate())
                        .endDate(challengeList.get(i).getEndDate())
                        .method(challengeList.get(i).getMethod())
                        .frequency(challengeList.get(i).getFrequency())
                        .summary(challengeList.get(i).getSummary())
                        .description(challengeList.get(i).getDescription())
                        .max(challengeList.get(i).getMax())
                        .current(current)
                        .img(challengeList.get(i).getImg())
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
