package ksafinalproject.gbt.userCustom.service;

import ksafinalproject.gbt.userCustom.model.UserCustom;

import java.util.List;
import java.util.Optional;

public interface UserCustomService {

    int saveUserCustom(UserCustom userCustom);

    Optional<UserCustom> getUserCustomById(Long id);

    List<UserCustom> getAllUserCustom();

    int deleteUserCustomById(Long id);

    List<UserCustom> getAllUserCustomByUserId(Long userid);

    List<UserCustom> getAllUserCustomByCustomId(Long customId);
}
