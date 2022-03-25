package ksafinalproject.gbt.challengeImg.service;

import ksafinalproject.gbt.challengeImg.model.ChallengeImg;

import java.util.List;

public interface ChallengeImgService {
    int saveChallengeImg(ChallengeImg challengeImg);

    List<ChallengeImg> getAllChallengeImg();

    List<ChallengeImg> getAllChallengeImgByChallengeId(Long challengeId);

    void deleteChallengeImgById(Long id);


}
