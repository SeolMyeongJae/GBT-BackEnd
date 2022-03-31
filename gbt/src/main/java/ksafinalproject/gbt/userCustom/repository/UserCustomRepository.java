package ksafinalproject.gbt.userCustom.repository;

import ksafinalproject.gbt.userCustom.model.UserCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCustomRepository extends JpaRepository<UserCustom, Long> {
    List<UserCustom> findAllByUserId(Long userId);

    List<UserCustom> findAllByCustomId(Long customId);
}
