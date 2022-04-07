package ksafinalproject.gbt.userChallenge.model;

import ksafinalproject.gbt.challenge.model.Challenge;
import ksafinalproject.gbt.user.model.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class UserChallenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;
    @ManyToOne
    @JoinColumn(name = "challenge_id")
    @NotNull
    private Challenge challenge;

    @Builder
    public UserChallenge(Long id, User user, Challenge challenge) {
        this.id = id;
        this.user = user;
        this.challenge = challenge;
    }
}
