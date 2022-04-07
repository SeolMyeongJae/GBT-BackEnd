package ksafinalproject.gbt.challenge.dto;

import ksafinalproject.gbt.challenge.model.Challenge;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OChallenge {
    private Long id;
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String method;
    private Long frequency;
    private String summary;
    private String description;
    private Long current;
    private Long max;
    private String img;

    @Builder
    public OChallenge(Long id, String title, LocalDateTime startDate, LocalDateTime endDate, String method, Long frequency, String summary, String description, Long current, Long max, String img) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.method = method;
        this.frequency = frequency;
        this.summary = summary;
        this.description = description;
        this.current = current;
        this.max = max;
        this.img = img;
    }
}
