package ksafinalproject.gbt.userCustom.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class IUserCustom {
    private Long id;
    private Long userId;
    private Long customChallengeId;
}
