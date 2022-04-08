package ksafinalproject.gbt.invite.service;

import ksafinalproject.gbt.invite.dto.IInvite;
import ksafinalproject.gbt.invite.model.Invite;

import java.util.List;
import java.util.Optional;

public interface InviteService {
    int saveInvite(IInvite iInvite);

    int updateInvite(IInvite iInvite, Long id);

    Optional<Invite> getInviteById(Long id);

    List<Invite> getAllInvite();

    int deleteInviteById(Long id);

    List<Invite> getAllInviteByUserId(Long userId);

    List<Invite> getAllInviteByCallUserId(Long callUserId);

}
