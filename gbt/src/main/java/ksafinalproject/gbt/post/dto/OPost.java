package ksafinalproject.gbt.post.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
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

    @Builder
    public OPost(Long id, String title, String content, String author, String img, String category, LocalDateTime created, LocalDateTime updated, Long userId, Long likes) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.img = img;
        this.category = category;
        this.created = created;
        this.updated = updated;
        this.userId = userId;
        this.likes = likes;
    }
}
