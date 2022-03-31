package ksafinalproject.gbt.challengeImg.controller;

import io.swagger.annotations.Api;
import ksafinalproject.gbt.challengeImg.model.ChallengeImg;
import ksafinalproject.gbt.challengeImg.service.ChallengeImgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags = {"챌린지이미지"})
@RestController
@CrossOrigin
@RequestMapping("/challenge-img")
@RequiredArgsConstructor
@Slf4j
public class ChallengeImgController {

    private final ChallengeImgService challengeImgService;

    @PostMapping("")
    public int challengeImgSave(@RequestBody ChallengeImg challengeImg) {
        try {
            return challengeImgService.saveChallengeImg(challengeImg);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @PutMapping("")
    public int challengeImgUpdate(@RequestBody ChallengeImg challengeImg) {
        try {
            return challengeImgService.saveChallengeImg(challengeImg);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/all")
    public List<ChallengeImg> challengeImgGetAll() {
        try {
            return challengeImgService.getAllChallengeImg();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/{id}")
    public Optional<ChallengeImg> challengeImgGetById(@PathVariable Long id) {
        try {
            return challengeImgService.getChallengeImgById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @GetMapping("/challenge/{challengeId}")
    public List<ChallengeImg> challengeImgGetAllByChallengeId(@PathVariable Long challengeId) {
        try {
            return challengeImgService.getAllChallengeImgByChallengeId(challengeId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public int challengeImgDeleteById(@PathVariable Long id) {
        try {
            return challengeImgService.deleteChallengeImgById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }
}
