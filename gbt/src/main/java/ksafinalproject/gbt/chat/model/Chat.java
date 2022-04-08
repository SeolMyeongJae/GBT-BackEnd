package ksafinalproject.gbt.chat.model;

import ksafinalproject.gbt.customChallenge.model.CustomChallenge;
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
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(length = 255)
    private String message;
    @NotNull
    private LocalDateTime created;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;
    @ManyToOne
    @JoinColumn(name = "custom_challenge_id")
    @NotNull
    private CustomChallenge customChallenge;

    @Builder
    public Chat(Long id, String message, LocalDateTime created, User user, CustomChallenge customChallenge) {
        this.id = id;
        this.message = message;
        this.created = created;
        this.user = user;
        this.customChallenge = customChallenge;
    }
}
