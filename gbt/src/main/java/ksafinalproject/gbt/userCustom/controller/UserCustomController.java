package ksafinalproject.gbt.userCustom.controller;

import io.swagger.annotations.Api;
import ksafinalproject.gbt.userCustom.model.UserCustom;
import ksafinalproject.gbt.userCustom.service.UserCustomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags = {"유저 커스텀 챌린지"})
@RestController
@CrossOrigin
@RequestMapping("/api/user-custom")
@RequiredArgsConstructor
@Slf4j
public class UserCustomController {

    private final UserCustomService userCustomService;

    @PostMapping("")
    public int userCustomSave(@RequestBody UserCustom userCustom) {
        try {
            return userCustomService.saveUserCustom(userCustom);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @PutMapping("")
    public int userCustomUpdate(@RequestBody UserCustom userCustom) {
        try {
            return userCustomService.saveUserCustom(userCustom);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/{id}")
    public Optional<UserCustom> userCustomGetById(@PathVariable Long id) {
        try {
            return userCustomService.getUserCustomById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @GetMapping("/all")
    public List<UserCustom> userCustomGetAll() {
        try {
            return userCustomService.getAllUserCustom();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public int userCustomDeleteById(@PathVariable Long id) {
        try {
            return userCustomService.deleteUserCustomById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/all/user/{userId}")
    public List<UserCustom> userCustomGetAllByUserId(@PathVariable Long userId) {
        try {
            return userCustomService.getAllUserCustomByUserId(userId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/all/custom/{customId}")
    public List<UserCustom> userCustomGetAllByCustomId(@PathVariable Long customId) {
        try {
            return userCustomService.getAllUserCustomByCustomId(customId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}
