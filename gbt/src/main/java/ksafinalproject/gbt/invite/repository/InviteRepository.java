package ksafinalproject.gbt.invite.repository;

import ksafinalproject.gbt.invite.model.Invite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InviteRepository extends JpaRepository<Invite, Long> {
    List<Invite> findAllByCallerId(Long callerId);

    List<Invite> findAllByUserId(Long userid);
}
