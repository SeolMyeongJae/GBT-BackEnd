package ksafinalproject.gbt.invite.model;

import ksafinalproject.gbt.customChallenge.model.CustomChallenge;
import ksafinalproject.gbt.user.model.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @ManyToOne
    @JoinColumn(name = "call_user_id")
    @NotNull
    private User callUser;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;
    @ManyToOne
    @JoinColumn(name = "custom_challenge_id")
    @NotNull
    private CustomChallenge customChallenge;

}
