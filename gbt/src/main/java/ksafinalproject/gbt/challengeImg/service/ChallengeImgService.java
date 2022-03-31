package ksafinalproject.gbt.challengeImg.service;

import ksafinalproject.gbt.challengeImg.model.ChallengeImg;

import java.util.List;
import java.util.Optional;

public interface ChallengeImgService {
    int saveChallengeImg(ChallengeImg challengeImg);

    Optional<ChallengeImg> getChallengeImgById(Long id);

    List<ChallengeImg> getAllChallengeImg();

    List<ChallengeImg> getAllChallengeImgByChallengeId(Long challengeId);

    int deleteChallengeImgById(Long id);


}
