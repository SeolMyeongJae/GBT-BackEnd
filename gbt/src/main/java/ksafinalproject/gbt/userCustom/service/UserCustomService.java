package ksafinalproject.gbt.userCustom.service;

import ksafinalproject.gbt.userCustom.dto.IUserCustom;
import ksafinalproject.gbt.userCustom.model.UserCustom;

import java.util.List;
import java.util.Optional;

public interface UserCustomService {

    int saveUserCustom(IUserCustom iUserCustom);

    int updateUserCustom(IUserCustom iUserCustom, Long id);

    Optional<UserCustom> getUserCustomById(Long id);

    List<UserCustom> getAllUserCustom();

    int deleteUserCustomById(Long id);

    List<UserCustom> getAllUserCustomByUserId(Long userid);

    List<UserCustom> getAllUserCustomByCustomChallengeId(Long customChallengeId);
}
