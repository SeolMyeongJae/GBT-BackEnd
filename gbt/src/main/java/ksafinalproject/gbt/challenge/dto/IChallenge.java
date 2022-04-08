package ksafinalproject.gbt.challenge.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class IChallenge {
    private Long id;
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String method;
    private Long frequency;
    private String description;
    private String summary;
    private Long max;
    private String img;
}
