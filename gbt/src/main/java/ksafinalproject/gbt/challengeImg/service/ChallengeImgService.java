package ksafinalproject.gbt.challengeImg.service;

import ksafinalproject.gbt.challengeImg.dto.IChallengeImg;
import ksafinalproject.gbt.challengeImg.model.ChallengeImg;

import java.util.List;
import java.util.Optional;

public interface ChallengeImgService {
    int saveChallengeImg(IChallengeImg iChallengeImg);

    int updateChallengeImg(IChallengeImg iChallengeImg, Long id);

    Optional<ChallengeImg> getChallengeImgById(Long id);

    List<ChallengeImg> getAllChallengeImg();

    List<ChallengeImg> getAllChallengeImgByChallengeId(Long challengeId);

    int deleteChallengeImgById(Long id);


}
