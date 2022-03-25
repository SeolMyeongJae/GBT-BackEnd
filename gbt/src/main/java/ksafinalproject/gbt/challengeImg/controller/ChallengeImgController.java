package ksafinalproject.gbt.challengeImg.controller;

import ksafinalproject.gbt.challengeImg.model.ChallengeImg;
import ksafinalproject.gbt.challengeImg.service.ChallengeImgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/challenge-img")
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
            return 2;
        }
    }

    @PutMapping("")
    public int challengeImgUpdate(@RequestBody ChallengeImg challengeImg) {
        try {
            return challengeImgService.saveChallengeImg(challengeImg);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return 2;
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
            challengeImgService.deleteChallengeImgById(id);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return 2;
        }
    }
}
