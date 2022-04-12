package ksafinalproject.gbt.post.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ksafinalproject.gbt.comment.model.Comment;
import ksafinalproject.gbt.likes.model.Likes;
import ksafinalproject.gbt.user.model.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(length = 255)
    private String title;
    @NotNull
    private String content;
    @NotNull
    @Column(length = 20)
    private String author;
    @Column(length = 255)
    private String img;
    @NotNull
    @Column(length = 255)
    private String category;
    @NotNull
    private LocalDateTime created;
    private LocalDateTime updated;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    @JsonBackReference
    private User user;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "post")
    @ToString.Exclude
    private Set<Comment> comment;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "post")
    @ToString.Exclude
    private Set<Likes> likes;

    @Builder
    public Post(Long id, String title, String content, String author, String img, String category, LocalDateTime created, LocalDateTime updated, User user, Set<Comment> comment, Set<Likes> likes) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.img = img;
        this.category = category;
        this.created = created;
        this.updated = updated;
        this.user = user;
        this.comment = comment;
        this.likes = likes;
    }
}
