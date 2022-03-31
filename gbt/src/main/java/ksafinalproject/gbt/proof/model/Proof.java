package ksafinalproject.gbt.proof.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NotNull
    private Long userId;
    @NotNull
    private Long challengeId;

    @Builder
    public Proof(Long id, String content, LocalDateTime date, Long userId, Long challengeId) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.userId = userId;
        this.challengeId = challengeId;
    }
}
