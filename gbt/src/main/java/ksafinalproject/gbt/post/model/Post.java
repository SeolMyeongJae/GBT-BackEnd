package ksafinalproject.gbt.post.model;

import ksafinalproject.gbt.comment.model.Comment;
import ksafinalproject.gbt.likes.model.Likes;
import ksafinalproject.gbt.user.model.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

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
    private User user;
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "comment_id")
//    private List<Comment> comment;
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "likes_id")
//    private List<Likes> likes;

    @Builder
    public Post(Long id, String title, String content, String author, String img, String category, LocalDateTime created, LocalDateTime updated, User user, List<Comment> comment, List<Likes> likes) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.img = img;
        this.category = category;
        this.created = created;
        this.updated = updated;
        this.user = user;
//        this.comment = comment;
//        this.likes = likes;
    }
}
