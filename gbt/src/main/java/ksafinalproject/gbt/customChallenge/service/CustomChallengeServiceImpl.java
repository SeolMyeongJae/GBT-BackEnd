package ksafinalproject.gbt.customChallenge.service;

import ksafinalproject.gbt.challenge.dto.OChallenge;
import ksafinalproject.gbt.customChallenge.dto.ICustomChallenge;
import ksafinalproject.gbt.customChallenge.dto.OCustomChallenge;
import ksafinalproject.gbt.customChallenge.model.CustomChallenge;
import ksafinalproject.gbt.customChallenge.repository.CustomChallengeRepository;
import ksafinalproject.gbt.user.repository.UserRepository;
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

public class CustomChallengeServiceImpl implements CustomChallengeService {

    private final CustomChallengeRepository customChallengeRepository;
    private final UserRepository userRepository;

    @Override
    public int saveCustomChallenge(ICustomChallenge iCustomChallenge) {
        log.info("save custom challenge : {}", iCustomChallenge);
        try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
//            LocalDateTime startDate = LocalDateTime.parse(iCustomChallenge.getStartDate(), formatter);
//            LocalDateTime endDate = LocalDateTime.parse(iCustomChallenge.getEndDate(), formatter);
            customChallengeRepository.save(CustomChallenge.builder()
                    .id(iCustomChallenge.getId())
                    .creator(userRepository.findById(iCustomChallenge.getCreatorId()).orElseThrow())
                    .startDate(iCustomChallenge.getStartDate())
                    .endDate(iCustomChallenge.getEndDate())
                    .method(iCustomChallenge.getMethod())
                    .title(iCustomChallenge.getTitle())
                    .frequency(iCustomChallenge.getFrequency())
                    .summary(iCustomChallenge.getSummary())
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
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
//        LocalDateTime startDate = LocalDateTime.parse(iCustomChallenge.getStartDate(), formatter);
//        LocalDateTime endDate = LocalDateTime.parse(iCustomChallenge.getEndDate(), formatter);
        try {
            if (customChallengeRepository.findById(id).isEmpty()) {
                return -1;
            }
            CustomChallenge customChallenge = customChallengeRepository.findById(id).orElseThrow();
            customChallenge.setStartDate(iCustomChallenge.getStartDate());
            customChallenge.setEndDate(iCustomChallenge.getEndDate());
            customChallenge.setTitle(iCustomChallenge.getTitle());
            customChallenge.setFrequency(iCustomChallenge.getFrequency());
            customChallenge.setSummary(iCustomChallenge.getSummary());
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
    public Optional<OCustomChallenge> getCustomChallengeById(Long id) {
        log.info("find custom challenge by id : {}", id);
        try {
            Optional<CustomChallenge> customChallenge = customChallengeRepository.findById(id);
            Long creatorId = customChallenge.orElseThrow().getCreator().getId();
            OCustomChallenge oCustomChallenge = OCustomChallenge.builder()
                    .id(customChallenge.orElseThrow().getId())
                    .creatorId(creatorId)
                    .title(customChallenge.orElseThrow().getTitle())
                    .startDate(customChallenge.orElseThrow().getStartDate())
                    .endDate(customChallenge.orElseThrow().getEndDate())
                    .method(customChallenge.orElseThrow().getMethod())
                    .frequency(customChallenge.orElseThrow().getFrequency())
                    .summary(customChallenge.orElseThrow().getSummary())
                    .description(customChallenge.orElseThrow().getDescription())
                    .max(customChallenge.orElseThrow().getMax())
                    .img(customChallenge.orElseThrow().getImg())
                    .chat(customChallenge.orElseThrow().getChat())
                    .build();
            return Optional.of(oCustomChallenge);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<OCustomChallenge> getAllCustomChallenge() {
        log.info("find all custom challenge");
        try {
            List<CustomChallenge> customChallengeList = customChallengeRepository.findAll();
            List<OCustomChallenge> oCustomChallengeList = new ArrayList<>();
            for (CustomChallenge customChallenge : customChallengeList) {
                Long creatorId = customChallenge.getCreator().getId();
                oCustomChallengeList.add(OCustomChallenge.builder()
                        .id(customChallenge.getId())
                        .creatorId(creatorId)
                        .title(customChallenge.getTitle())
                        .startDate(customChallenge.getStartDate())
                        .endDate(customChallenge.getEndDate())
                        .method(customChallenge.getMethod())
                        .frequency(customChallenge.getFrequency())
                        .summary(customChallenge.getSummary())
                        .description(customChallenge.getDescription())
                        .max(customChallenge.getMax())
                        .img(customChallenge.getImg())
                        .chat(customChallenge.getChat())
                        .build());
            }
            return oCustomChallengeList;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<OCustomChallenge> getAllCustomChallengeByCreatorId(Long creatorId) {
        log.info("find all custom challenge by creator id : {}", creatorId);
        try {
            List<CustomChallenge> customChallengeList = customChallengeRepository.findAllByCreatorId(creatorId);
            List<OCustomChallenge> oCustomChallengeList = new ArrayList<>();
            for (CustomChallenge customChallenge : customChallengeList) {
                Long creatorId2 = customChallenge.getCreator().getId();
                oCustomChallengeList.add(OCustomChallenge.builder()
                        .id(customChallenge.getId())
                        .creatorId(creatorId2)
                        .title(customChallenge.getTitle())
                        .startDate(customChallenge.getStartDate())
                        .endDate(customChallenge.getEndDate())
                        .method(customChallenge.getMethod())
                        .frequency(customChallenge.getFrequency())
                        .summary(customChallenge.getSummary())
                        .description(customChallenge.getDescription())
                        .max(customChallenge.getMax())
                        .img(customChallenge.getImg())
                        .chat(customChallenge.getChat())
                        .build());
            }
            return oCustomChallengeList;
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
