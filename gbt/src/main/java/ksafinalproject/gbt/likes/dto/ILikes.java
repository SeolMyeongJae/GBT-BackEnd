package ksafinalproject.gbt.likes.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ILikes {
    private Long id;
    private Long postId;
    private Long userId;
}
