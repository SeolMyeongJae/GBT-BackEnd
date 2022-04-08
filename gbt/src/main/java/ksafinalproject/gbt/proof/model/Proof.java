package ksafinalproject.gbt.proof.model;

import ksafinalproject.gbt.challenge.model.Challenge;
import ksafinalproject.gbt.user.model.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Proof {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String content;
    @NotNull
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;
    @ManyToOne
    @JoinColumn(name = "challenge_id")
    @NotNull
    private Challenge challenge;

    @Builder
    public Proof(Long id, String content, LocalDateTime date, User user, Challenge challenge) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.user = user;
        this.challenge = challenge;
    }
}
