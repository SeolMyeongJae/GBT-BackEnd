package ksafinalproject.gbt.user.model;

import javax.validation.constraints.NotNull;

import lombok.*;

import javax.persistence.*;
import java.time.Year;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
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
    private Year birthYear;
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

    @Builder
    public User(Long id, String userName, String gender, Year birthYear, Long smokingYear, String comment, Long price, Long averageSmoking, Long ranking, String profileImg, String popupImg, Long point, Long badgeId) {
        this.id = id;
        this.userName = userName;
        this.gender = gender;
        this.birthYear = birthYear;
        this.smokingYear = smokingYear;
        this.comment = comment;
        this.price = price;
        this.averageSmoking = averageSmoking;
        this.ranking = ranking;
        this.profileImg = profileImg;
        this.popupImg = popupImg;
        this.point = point;
        this.badgeId = badgeId;
    }
}
