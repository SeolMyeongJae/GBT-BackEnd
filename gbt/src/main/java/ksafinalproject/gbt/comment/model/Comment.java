package ksafinalproject.gbt.comment.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(length = 255)
    private String comment;
    @NotNull
    @Column(length = 20)
    private String author;
    @NotNull
    private LocalDateTime created;
    private LocalDateTime updated;
    @NotNull
    private Long postId;

    @Builder

    public Comment(Long id, String comment, String author, LocalDateTime created, LocalDateTime updated, Long postId) {
        this.id = id;
        this.comment = comment;
        this.author = author;
        this.created = created;
        this.updated = updated;
        this.postId = postId;
    }
}
