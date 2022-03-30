package ksafinalproject.gbt.challenge.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class IChallenge {
    private Long id;
    private String title;
    private String startDate;
    private String endDate;
    private String method;
    private Long frequency;
    private String description;
    private Long max;
    private String img;
}
