package ksafinalproject.gbt.userCustom.service;

import ksafinalproject.gbt.userCustom.model.UserCustom;
import ksafinalproject.gbt.userCustom.repository.UserCustomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserCustomServiceImpl implements UserCustomService {

    private final UserCustomRepository userCustomRepository;

    @Override
    public int saveUserCustom(UserCustom userCustom) {
        log.info("save user custom : {}", userCustom);
        try {
            userCustomRepository.save(userCustom);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Transactional
    @Override
    public int updateUserCustom(UserCustom userCustom, Long id) {
        log.info("update user custom : {}, id : {}", userCustom, id);
        try {
            UserCustom userCustom2 = userCustomRepository.findById(id).orElseThrow();
            userCustom2.setCustomId(userCustom.getCustomId());
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public Optional<UserCustom> getUserCustomById(Long id) {
        log.info("find user custom by id : {}", id);
        try {
            return userCustomRepository.findById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<UserCustom> getAllUserCustom() {
        log.info("find all user custom");
        try {
            return userCustomRepository.findAll();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public int deleteUserCustomById(Long id) {
        log.info("delete user custom by id : {}", id);
        try {
            userCustomRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public List<UserCustom> getAllUserCustomByUserId(Long userid) {
        log.info("find all user custom by user id : {}", userid);
        try {
            return userCustomRepository.findAllByUserId(userid);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<UserCustom> getAllUserCustomByCustomId(Long customId) {
        log.info("find all user custom by custom id : {}", customId);
        try {
            return userCustomRepository.findAllByCustomId(customId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}
