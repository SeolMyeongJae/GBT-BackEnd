package ksafinalproject.gbt.customImg.service;

import ksafinalproject.gbt.customImg.model.CustomImg;

import java.util.List;
import java.util.Optional;

public interface CustomImgService {

    int saveCustomImg(CustomImg customImg);

    Optional<CustomImg> getCustomImgById(Long id);

    List<CustomImg> getAllCustomImg();

    List<CustomImg> getAllCustomImgByCustomId(Long customId);

    int deleteCustomImgById(Long id);
}
