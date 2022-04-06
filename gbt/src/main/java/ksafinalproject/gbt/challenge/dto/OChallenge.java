package ksafinalproject.gbt.challenge.dto;

import ksafinalproject.gbt.challenge.model.Challenge;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OChallenge {
    Challenge challenge;
    private Long current;
}
