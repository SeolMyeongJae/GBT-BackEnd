package ksafinalproject.gbt.challengeImg.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class IChallengeImg {

    private Long id;
    private String url;
    private Long challengeId;
}
