package ksafinalproject.gbt.customChallenge.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class OCustomChallenge {

    private Long id;
    private Long creatorId;
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String method;
    private Long frequency;
    private String summary;
    private String description;
    private Long max;
    private String img;

    @Builder
    public OCustomChallenge(Long id, Long creatorId, String title, LocalDateTime startDate, LocalDateTime endDate, String method, Long frequency, String summary, String description, Long max, String img) {
        this.id = id;
        this.creatorId = creatorId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.method = method;
        this.frequency = frequency;
        this.summary = summary;
        this.description = description;
        this.max = max;
        this.img = img;
    }
}
