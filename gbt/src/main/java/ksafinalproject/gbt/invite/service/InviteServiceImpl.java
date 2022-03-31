package ksafinalproject.gbt.invite.service;

import ksafinalproject.gbt.invite.model.Invite;
import ksafinalproject.gbt.invite.repository.InviteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class InviteServiceImpl implements InviteService {

    private final InviteRepository inviteRepository;

    @Override
    public int saveInvite(Invite invite) {
        log.info("save invite : {}", invite);
        try {
            inviteRepository.save(Invite.builder()
                    .id(invite.getId())
                    .title(invite.getTitle())
                    .caller(invite.getCaller())
                    .date(LocalDate.now())
                    .callerId(invite.getCallerId())
                    .userId(invite.getUserId())
                    .customChallengeId(invite.getCustomChallengeId())
                    .build());
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public Optional<Invite> getInviteById(Long id) {
        log.info("get invite by id : {}", id);
        try {
            return inviteRepository.findById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Invite> getAllInvite() {
        log.info("get all invite");
        try {
            return inviteRepository.findAll();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public int deleteInviteById(Long id) {
        log.info("delete invite by id : {}", id);
        try {
            inviteRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public List<Invite> getAllInviteByUserId(Long userId) {
        log.info("get all invite by user id : {}", userId);
        try {
            return inviteRepository.findAllByUserId(userId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<Invite> getAllInviteByCallerId(Long callerId) {
        log.info("get all invite by caller id : {}", callerId);
        try {
            return inviteRepository.findAllByCallerId(callerId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}
