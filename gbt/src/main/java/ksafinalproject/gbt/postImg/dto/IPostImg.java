package ksafinalproject.gbt.postImg.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class IPostImg {
    private Long id;
    private String url;
    private Long postId;
}