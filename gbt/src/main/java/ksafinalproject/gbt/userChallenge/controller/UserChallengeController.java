package ksafinalproject.gbt.userChallenge.controller;

import io.swagger.annotations.Api;
import ksafinalproject.gbt.userChallenge.model.UserChallenge;
import ksafinalproject.gbt.userChallenge.service.UserChallengeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags = {"유저챌린지"})
@RestController
@CrossOrigin
@RequestMapping("/api/user-challenge")
@RequiredArgsConstructor
@Slf4j
public class UserChallengeController {

    private final UserChallengeService userChallengeService;

    @PostMapping("")
    public int userChallengeSave(@RequestBody UserChallenge userChallenge) {
        try {
            return userChallengeService.saveUserChallenge(userChallenge);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @PutMapping("/{id}")
    public int userChallengeUpdate(@RequestBody UserChallenge userChallenge, @PathVariable Long id) {
        try {
            return userChallengeService.updateUserChallenge(userChallenge, id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/{id}")
    public Optional<UserChallenge> userChallengeGetById(@PathVariable Long id) {
        try {
            return userChallengeService.getUserChallengeById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @GetMapping("/all")
    public List<UserChallenge> userChallengeGetAll() {
        try {
            return userChallengeService.getAllUserChallenge();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public int userChallengeDeleteById(@PathVariable Long id) {
        try {
            return userChallengeService.deleteUserChallengeById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/all/user/{userId}")
    public List<UserChallenge> userChallengeGetAllByUserId(@PathVariable Long userId) {
        try {
            return userChallengeService.getAllUserChallengeByUserId(userId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/all/challenge/{challengeId}")
    public List<UserChallenge> userChallengeGetAllByChallengeId(@PathVariable Long challengeId) {
        try {
            return userChallengeService.getAllUserChallengeByChallengeId(challengeId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}
