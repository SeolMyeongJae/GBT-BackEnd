package ksafinalproject.gbt.user.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
public class IUser {

    private Long id;
    private String userName;
    private String gender;
    private int birthYear;
    private Long smokingYear;
    private String comment;
    private Long price;
    private Long averageSmoking;
    private Long ranking;
    private String profileImg;
    private String popupImg;
    private Long point;
    private Long badgeId;

    @Builder
    public IUser(Long id, String userName, String gender, int birthYear, Long smokingYear, String comment, Long price, Long averageSmoking, Long ranking, String profileImg, String popupImg, Long point, Long badgeId) {
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
