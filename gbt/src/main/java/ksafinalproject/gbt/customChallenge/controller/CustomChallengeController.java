package ksafinalproject.gbt.customChallenge.controller;

import ksafinalproject.gbt.customChallenge.model.CustomChallenge;
import ksafinalproject.gbt.customChallenge.service.CustomChallengeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/custom")
@RequiredArgsConstructor
@Slf4j
public class CustomChallengeController {
    private final CustomChallengeService customChallengeService;

    @PostMapping("")
    public int customChallengeSave(@RequestBody CustomChallenge customChallenge) {
        try {
            return customChallengeService.saveCustomChallenge(customChallenge);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return 2;
        }
    }

    @PutMapping("")
    public int customChallengeUpdate(@RequestBody CustomChallenge customChallenge) {
        try {
            if (customChallengeService.saveCustomChallenge(customChallenge) == 2) return 2;
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return 2;
        }
    }

    @GetMapping("/{id}")
    public Optional<CustomChallenge> customChallengeGetById(@PathVariable Long id) {
        try {
            return customChallengeService.getCustomChallengeById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @GetMapping("/all")
    public List<CustomChallenge> customChallengeGetAll() {
        try {
            return customChallengeService.getAllCustomChallenge();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}
