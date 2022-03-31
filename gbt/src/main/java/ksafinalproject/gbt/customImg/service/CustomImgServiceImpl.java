package ksafinalproject.gbt.customImg.service;

import ksafinalproject.gbt.customImg.model.CustomImg;
import ksafinalproject.gbt.customImg.repository.CustomImgRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class CustomImgServiceImpl implements CustomImgService {

    private final CustomImgRepository customImgRepository;

    @Override
    public int saveCustomImg(CustomImg customImg) {
        log.info("save custom img : {}", customImg);
        try {
            customImgRepository.save(customImg);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public List<CustomImg> getAllCustomImg() {
        log.info("find all custom img");
        try {
            return customImgRepository.findAll();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public Optional<CustomImg> getCustomImgById(Long id) {
        log.info("find custom img by id : {}", id);
        try {
            return customImgRepository.findById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<CustomImg> getAllCustomImgByCustomId(Long customId) {
        log.info("find all custom img by custom id");
        try {
            return customImgRepository.findAllByCustomId(customId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public int deleteCustomImgById(Long id) {
        log.info("delete custom img by id : {}", id);
        try {
            customImgRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }
}
