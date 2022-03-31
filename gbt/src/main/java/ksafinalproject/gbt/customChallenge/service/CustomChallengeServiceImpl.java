package ksafinalproject.gbt.customChallenge.service;

import ksafinalproject.gbt.customChallenge.dto.ICustomChallenge;
import ksafinalproject.gbt.customChallenge.model.CustomChallenge;
import ksafinalproject.gbt.customChallenge.repository.CustomChallengeRepository;
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

public class CustomChallengeServiceImpl implements CustomChallengeService {

    private final CustomChallengeRepository customChallengeRepository;

    @Override
    public int saveCustomChallenge(ICustomChallenge iCustomChallenge) {
        log.info("save custom challenge : {}", iCustomChallenge);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
            LocalDateTime startDate = LocalDateTime.parse(iCustomChallenge.getStartDate(), formatter);
            LocalDateTime endDate = LocalDateTime.parse(iCustomChallenge.getEndDate(), formatter);
            customChallengeRepository.save(CustomChallenge.builder()
                    .id(iCustomChallenge.getId())
                    .creatorId(iCustomChallenge.getCreatorId())
                    .startDate(startDate)
                    .endDate(endDate)
                    .method(iCustomChallenge.getMethod())
                    .title(iCustomChallenge.getTitle())
                    .frequency(iCustomChallenge.getFrequency())
                    .description(iCustomChallenge.getDescription())
                    .max(iCustomChallenge.getMax())
                    .img(iCustomChallenge.getImg())
                    .build());
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    @Transactional
    public int updateCustomChallenge(ICustomChallenge iCustomChallenge, Long id) {
        log.info("update custom challenge : {}, id : {}", iCustomChallenge, id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
        LocalDateTime startDate = LocalDateTime.parse(iCustomChallenge.getStartDate(), formatter);
        LocalDateTime endDate = LocalDateTime.parse(iCustomChallenge.getEndDate(), formatter);
        try {
            if (customChallengeRepository.findById(id).isEmpty()) {
                return -1;
            }
            CustomChallenge customChallenge = customChallengeRepository.findById(id).orElseThrow();
            customChallenge.setStartDate(startDate);
            customChallenge.setEndDate(endDate);
            customChallenge.setTitle(iCustomChallenge.getTitle());
            customChallenge.setFrequency(iCustomChallenge.getFrequency());
            customChallenge.setDescription(iCustomChallenge.getDescription());
            customChallenge.setMax(iCustomChallenge.getMax());
            customChallenge.setImg(iCustomChallenge.getImg());
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
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
    public List<CustomChallenge> getAllCustomChallengeByCreatorId(Long creatorId) {
        log.info("find all custom challenge by creator id : {}", creatorId);
        try {
            return customChallengeRepository.findAllByCreatorId(creatorId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public int deleteCustomChallengeById(Long id) {
        log.info("delete custom challenge by id : {}", id);
        try {
            customChallengeRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }
}
