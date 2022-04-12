package ksafinalproject.gbt.postImg.model;

import ksafinalproject.gbt.post.model.Post;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(length = 255)
    private String url;
    @ManyToOne
    @JoinColumn(name = "post_id")
    @NotNull
    private Post post;

}
