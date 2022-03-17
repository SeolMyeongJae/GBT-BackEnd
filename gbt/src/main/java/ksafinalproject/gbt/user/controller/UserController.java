package ksafinalproject.gbt.user.controller;

import ksafinalproject.gbt.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserController {
    int userSave(User user);
    int userUpdate(User user);
    Optional<User> userGetById(Long id);
    List<User> userGetAll();
    int userDeleteById(Long id);
    Optional<User> userGetByUserName(String userName);
}
