package ksafinalproject.gbt.user.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

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
    private String userName;
    @Column(length = 20)
    private String gender;
    private Date startDate;
    private Long goal;
    private Long price;
    private Long ranking;
    @Column(length = 255)
    private String profileImg;
    @Column(length = 255)
    private String popupImg;
    private Long point;
    private Long badgeId;
    private Long oauthId;
}
