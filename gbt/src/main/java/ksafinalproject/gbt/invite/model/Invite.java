package ksafinalproject.gbt.invite.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Invite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255)
    private String title;
    @Column(length = 20)
    private String caller;
    private LocalDate date;
    private Long callerId;
    private Long userId;
    private Long challengeId;

    @Builder
    public Invite(Long id, String title, String caller, LocalDate date, Long callerId, Long userId, Long challengeId) {
        this.id = id;
        this.title = title;
        this.caller = caller;
        this.date = date;
        this.callerId = callerId;
        this.userId = userId;
        this.challengeId = challengeId;
    }
}
