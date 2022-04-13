package ksafinalproject.gbt.challengeImg.model;

import javax.validation.constraints.NotNull;

import ksafinalproject.gbt.challenge.model.Challenge;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChallengeImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(length = 255)
    private String url;
    @ManyToOne
    @Column(name = "challenge_id")
    @NotNull
    private Challenge challenge;
}
