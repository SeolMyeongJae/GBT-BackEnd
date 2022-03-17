package ksafinalproject.gbt.user.service;

import ksafinalproject.gbt.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUserById(Long id);
    List<User> getAllUser();
    void deleteUserById(Long id);
    Optional<User> getUserByUserName(String userName);
}
