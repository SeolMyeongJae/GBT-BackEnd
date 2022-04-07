package ksafinalproject.gbt.challenge.model;

import javax.validation.constraints.NotNull;

import ksafinalproject.gbt.challengeImg.model.ChallengeImg;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(length = 255)
    private String title;
    @NotNull
    private LocalDateTime startDate;
    @NotNull
    private LocalDateTime endDate;
    @NotNull
    @Column(length = 50)
    private String method;
    @NotNull
    private Long frequency;
    @NotNull
    @Column(length = 50)
    private String summary;
    @NotNull
    @Column(length = 255)
    private String description;
    @NotNull
    private Long max;
    @NotNull
    @Column(length = 255)
    private String img;

    @Builder
    public Challenge(Long id, String title, LocalDateTime startDate, LocalDateTime endDate, String method, Long frequency, String description, String summary, Long max, String img) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.method = method;
        this.frequency = frequency;
        this.description = description;
        this.summary = summary;
        this.max = max;
        this.img = img;
    }
}
