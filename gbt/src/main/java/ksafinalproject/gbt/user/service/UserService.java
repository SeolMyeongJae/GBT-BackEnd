package ksafinalproject.gbt.user.service;

import ksafinalproject.gbt.user.dto.IUser;
import ksafinalproject.gbt.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    int saveUser(IUser iuser);

    int updateUser(IUser iuser);

    Optional<User> getUserById(Long id);

    List<User> getAllUser();

    void deleteUserById(Long id);

    Optional<User> getUserByUserName(String userName);
}
