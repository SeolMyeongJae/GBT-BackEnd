package ksafinalproject.gbt.customImg.service;

import ksafinalproject.gbt.customImg.dto.ICustomImg;
import ksafinalproject.gbt.customImg.model.CustomImg;

import java.util.List;
import java.util.Optional;

public interface CustomImgService {

    int saveCustomImg(ICustomImg iCustomImg);

    int updateCustomImg(ICustomImg iCustomImg, Long id);

    Optional<CustomImg> getCustomImgById(Long id);

    List<CustomImg> getAllCustomImg();

    List<CustomImg> getAllCustomImgByCustomChallengeId(Long customChallengeId);

    int deleteCustomImgById(Long id);
}
