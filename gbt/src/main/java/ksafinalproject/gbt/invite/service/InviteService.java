package ksafinalproject.gbt.invite.service;

import ksafinalproject.gbt.invite.model.Invite;

import java.util.List;
import java.util.Optional;

public interface InviteService {
    int saveInvite(Invite invite);

    Optional<Invite> getInviteById(Long id);

    List<Invite> getAllInvite();

    int deleteInviteById(Long id);

    List<Invite> getAllInviteByUserId(Long userId);

    List<Invite> getAllInviteByCallerId(Long callerId);

}
