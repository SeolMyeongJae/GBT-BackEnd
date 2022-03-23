package ksafinalproject.gbt.challenge.controller;

import ksafinalproject.gbt.challenge.model.Challenge;
import ksafinalproject.gbt.challenge.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/challenge")
@RequiredArgsConstructor
@Slf4j
public class ChallengeController {
    private final ChallengeService challengeService;

    @PostMapping("/save")
    public int challengeSave(@RequestBody Challenge challenge) {
        try {
            return challengeService.saveChallenge(challenge);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return 2;
        }
    }

    @PutMapping("/update")
    public int challengeUpdate(@RequestBody Challenge challenge) {
        try {
            if (challengeService.saveChallenge(challenge) == 2) return 2;
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return 2;
        }
    }

    @GetMapping("/get/{id}")
    public Optional<Challenge> challengeGetById(@PathVariable Long id) {
        try {
            return challengeService.getChallengeById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @GetMapping("/get/all")
    public List<Challenge> challengeGetAll() {
        try {
            return challengeService.getAllChallenge();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}
