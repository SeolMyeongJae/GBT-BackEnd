package ksafinalproject.gbt.customImg.model;

import javax.validation.constraints.NotNull;

import ksafinalproject.gbt.customChallenge.model.CustomChallenge;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class CustomImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(length = 255)
    private String url;
    @ManyToOne
    @JoinColumn(name = "custom_challenge_id")
    @NotNull
    private CustomChallenge customChallenge;

    @Builder
    public CustomImg(Long id, String url, CustomChallenge customChallenge) {
        this.id = id;
        this.url = url;
        this.customChallenge = customChallenge;
    }
}
