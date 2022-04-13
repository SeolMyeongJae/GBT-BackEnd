package ksafinalproject.gbt.post.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OPost {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String img;
    private String category;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Long userId;
    private Long likes;

}
