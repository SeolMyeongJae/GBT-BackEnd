package ksafinalproject.gbt.invite.controller;

import ksafinalproject.gbt.invite.model.Invite;
import ksafinalproject.gbt.invite.service.InviteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/invite")
@RequiredArgsConstructor
@Slf4j
public class InviteController {
    private final InviteService inviteService;

    @PostMapping("")
    public int inviteSave(@RequestBody Invite invite) {
        try {
            return inviteService.saveInvite(invite);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @PutMapping("")
    public int inviteUpdate(@RequestBody Invite invite) {
        try {
            return inviteService.saveInvite(invite);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/{id}")
    public Optional<Invite> inviteGetById(@PathVariable Long id) {
        try {
            return inviteService.getInviteById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @GetMapping("/all")
    public List<Invite> inviteGetAll() {
        try {
            return inviteService.getAllInvite();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public int inviteDeleteById(@PathVariable Long id) {
        try {
            return inviteService.deleteInviteById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/all/caller/{callerId}")
    public List<Invite> inviteGetAllByCallerId(@PathVariable Long callerId) {
        try {
            return inviteService.getAllInviteByCallerId(callerId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/all/user/{userId}")
    public List<Invite> inviteGetAllByUserId(@PathVariable Long userId) {
        try {
            return inviteService.getAllInviteByUserId(userId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}
