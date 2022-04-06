package ksafinalproject.gbt.challengeImg.service;

import ksafinalproject.gbt.challengeImg.model.ChallengeImg;
import ksafinalproject.gbt.challengeImg.repository.ChallengeImgRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class ChallengeImgServiceImpl implements ChallengeImgService {

    private final ChallengeImgRepository challengeImgRepository;

    @Override
    public int saveChallengeImg(ChallengeImg challengeImg) {
        log.info("save challenge img : {}", challengeImg);
        try {
            challengeImgRepository.save(challengeImg);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Transactional
    @Override
    public int updateChallengeImg(ChallengeImg challengeImg, Long id) {
        log.info("update challenge img : {}, id : {}", challengeImg, id);
        try {
            ChallengeImg challengeImg2 = challengeImgRepository.findById(id).orElseThrow();
            challengeImg2.setUrl(challengeImg.getUrl());
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public Optional<ChallengeImg> getChallengeImgById(Long id) {
        log.info("find challenge img by id : {}", id);
        try {
            return challengeImgRepository.findById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<ChallengeImg> getAllChallengeImg() {
        log.info("find all challenge img");
        try {
            return challengeImgRepository.findAll();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<ChallengeImg> getAllChallengeImgByChallengeId(Long challengeId) {
        log.info("find all challenge img by challenge id {}", challengeId);
        try {
            return challengeImgRepository.findAllByChallengeId(challengeId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public int deleteChallengeImgById(Long id) {
        log.info("delete challenge img by id {}", id);
        try {
            challengeImgRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }
}