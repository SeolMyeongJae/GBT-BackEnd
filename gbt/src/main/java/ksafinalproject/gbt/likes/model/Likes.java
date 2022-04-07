package ksafinalproject.gbt.likes.model;

import ksafinalproject.gbt.post.model.Post;
import ksafinalproject.gbt.user.model.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "post_id")
    @NotNull
    private Post post;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @Builder
    public Likes(Long id, Post post, User user) {
        this.id = id;
        this.post = post;
        this.user = user;
    }
}
