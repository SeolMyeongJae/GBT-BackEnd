package ksafinalproject.gbt.customImg.controller;


import io.swagger.annotations.Api;
import ksafinalproject.gbt.customImg.model.CustomImg;
import ksafinalproject.gbt.customImg.service.CustomImgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags = {"커스텀챌린지 이미지"})
@RestController
@CrossOrigin
@RequestMapping("/custom-img")
@RequiredArgsConstructor
@Slf4j
public class CustomImgController {

    private final CustomImgService customImgService;

    @PostMapping("")
    public int customImgSave(@RequestBody CustomImg customImg) {
        try {
            return customImgService.saveCustomImg(customImg);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @PutMapping("")
    public int customImgUpdate(@RequestBody CustomImg customImg) {
        try {
            return customImgService.saveCustomImg(customImg);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/{id}")
    public Optional<CustomImg> customImgGetById(@PathVariable Long id) {
        try {
            return customImgService.getCustomImgById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @GetMapping("/all")
    public List<CustomImg> customImgGetAll() {
        try {
            return customImgService.getAllCustomImg();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/custom/{customId}")
    public List<CustomImg> customImgGetAllByCustomId(@PathVariable Long customId) {
        try {
            return customImgService.getAllCustomImgByCustomId(customId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public int customImgDeleteById(@PathVariable Long id) {
        try {
            return customImgService.deleteCustomImgById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }
}