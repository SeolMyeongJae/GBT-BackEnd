package ksafinalproject.gbt.challengeImg.service;

import ksafinalproject.gbt.challengeImg.model.ChallengeImg;
import ksafinalproject.gbt.challengeImg.repository.ChallengeImgRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
            return 2;
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
    public void deleteChallengeImgById(Long id) {
        log.info("delete challenge img by id {}", id);
        try {
            challengeImgRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
        }
    }
}
