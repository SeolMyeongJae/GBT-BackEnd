package ksafinalproject.gbt.userCustom.model;

import ksafinalproject.gbt.customChallenge.model.CustomChallenge;
import ksafinalproject.gbt.user.model.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class UserCustom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;
    @ManyToOne
    @JoinColumn(name = "custom_challenge_id")
    @NotNull
    private CustomChallenge customChallenge;

    @Builder
    public UserCustom(Long id, User user, CustomChallenge customChallenge) {
        this.id = id;
        this.user = user;
        this.customChallenge = customChallenge;
    }
}
