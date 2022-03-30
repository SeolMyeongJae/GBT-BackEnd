package ksafinalproject.gbt.customChallenge.model;

import javax.validation.constraints.NotNull;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class CustomChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long creatorId;
    @NotNull
    @Column(length = 255)
    private String title;
    @NotNull
    private LocalDateTime startDate;
    @NotNull
    private LocalDateTime endDate;
    @Column(length = 50)
    private String method;
    private Long frequency;
    @NotNull
    @Column(length = 255)
    private String description;
    private Long max;
    @Column(length = 255)
    private String img;

    @Builder
    public CustomChallenge(Long id, Long creatorId, String title, LocalDateTime startDate, LocalDateTime endDate, String method, Long frequency, String description, Long max, String img) {
        this.id = id;
        this.creatorId = creatorId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.method = method;
        this.frequency = frequency;
        this.description = description;
        this.max = max;
        this.img = img;
    }
}
