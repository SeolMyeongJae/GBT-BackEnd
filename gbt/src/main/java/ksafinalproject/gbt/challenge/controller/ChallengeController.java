package ksafinalproject.gbt.challenge.controller;

import ksafinalproject.gbt.challenge.dto.IChallenge;
import ksafinalproject.gbt.challenge.model.Challenge;
import ksafinalproject.gbt.challenge.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/challenge")
@RequiredArgsConstructor
@Slf4j
public class ChallengeController {
    private final ChallengeService challengeService;

    @PostMapping("")
    public int challengeSave(@RequestBody IChallenge iChallenge) {
        try {
            return challengeService.saveChallenge(iChallenge);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @PutMapping("/{id}")
    public int challengeUpdate(@RequestBody IChallenge iChallenge, @PathVariable Long id) {
        try {
            return challengeService.updateChallenge(iChallenge, id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/{id}")
    public Optional<Challenge> challengeGetById(@PathVariable Long id) {
        try {
            return challengeService.getChallengeById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @GetMapping("/all")
    public List<Challenge> challengeGetAll() {
        try {
            return challengeService.getAllChallenge();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public int challengeDeleteById(@PathVariable Long id) {
        try {
            return challengeService.deleteChallengeById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }
}
