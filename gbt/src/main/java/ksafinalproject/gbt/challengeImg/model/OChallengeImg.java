package ksafinalproject.gbt.challengeImg.model;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OChallengeImg {
    private Long id;
    private String url;
    private Long challengeId;
}
