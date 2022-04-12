package ksafinalproject.gbt.customChallenge.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

}
