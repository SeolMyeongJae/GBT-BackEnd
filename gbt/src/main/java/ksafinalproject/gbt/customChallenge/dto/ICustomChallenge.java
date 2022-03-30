package ksafinalproject.gbt.customChallenge.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ICustomChallenge {

    private Long id;
    private Long creatorId;
    private String title;
    private String startDate;
    private String endDate;
    private String method;
    private Long frequency;
    private String description;
    private Long max;
    private String img;
}
