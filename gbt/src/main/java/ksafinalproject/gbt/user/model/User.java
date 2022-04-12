package ksafinalproject.gbt.user.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import ksafinalproject.gbt.chat.model.Chat;
import ksafinalproject.gbt.customChallenge.model.CustomChallenge;
import ksafinalproject.gbt.likes.model.Likes;
import ksafinalproject.gbt.post.model.Post;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    @NotNull
    private String userName;
    @NotNull
    @Column(length = 20)
    private String gender;
    @NotNull
    private LocalDate birthYear;
    @NotNull
    private Long smokingYear;
    @NotNull
    @Column(length = 255)
    private String comment;
    @NotNull
    private Long price;
    private Long averageSmoking;
    private Long ranking;
    @Column(length = 255)
    private String profileImg;
    @Column(length = 255)
    private String popupImg;
    private Long point;
    private Long badgeId;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "user")
    @ToString.Exclude
    private Set<Post> post;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "creator")
    @ToString.Exclude
    private Set<CustomChallenge> customChallenge;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "user")
    private Set<Chat> chat;
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "user")
//    @ToString.Exclude
//    private Set<Likes> likes;

}
