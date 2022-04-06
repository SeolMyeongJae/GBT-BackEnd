package ksafinalproject.gbt.invite.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull
    @Column(length = 255)
    private String title;
    @NotNull
    @Column(length = 20)
    private String caller;
    @NotNull
    private LocalDate date;
    @NotNull
    private Long callerId;
    @NotNull
    private Long userId;
    @NotNull
    private Long customChallengeId;

    @Builder
    public Invite(Long id, String title, String caller, LocalDate date, Long callerId, Long userId, Long customChallengeId) {
        this.id = id;
        this.title = title;
        this.caller = caller;
        this.date = date;
        this.callerId = callerId;
        this.userId = userId;
        this.customChallengeId = customChallengeId;
    }
}
