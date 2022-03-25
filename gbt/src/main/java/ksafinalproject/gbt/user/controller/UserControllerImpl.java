package ksafinalproject.gbt.user.controller;

import ksafinalproject.gbt.user.model.User;
import ksafinalproject.gbt.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Override
    @PostMapping("/save")
    public int userSave(@RequestBody User user) {
        try {
            if (userService.saveUser(user) == null) return 2;
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return 2;
        }
    }

    @Override
    @PutMapping("/update")
    public int userUpdate(@RequestBody User user) {
        try {
            if (userService.saveUser(user) == null) return 2;
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return 2;
        }
    }

    @Override
    @GetMapping("/get/{id}")
    public Optional<User> userGetById(@PathVariable Long id) {
        try {
            return userService.getUserById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    @GetMapping("/get/all")
    public List<User> userGetAll() {
        try {
            return userService.getAllUser();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public int userDeleteById(@PathVariable Long id) {
        try {
            userService.deleteUserById(id);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return 2;
        }
    }

    @Override
    @GetMapping("/get/username/{userName}")
    public Optional<User> userGetByUserName(@PathVariable String userName) {
        try {
            return userService.getUserByUserName(userName);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }
}
