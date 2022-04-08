package ksafinalproject.gbt.smoking.model;

import javax.validation.constraints.NotNull;

import ksafinalproject.gbt.user.model.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Smoking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long count;
    @NotNull
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;
    @NotNull
    @Column(length = 10)
    private String provider;

    @Builder
    public Smoking(Long id, Long count, LocalDate date, User user, String provider) {
        this.id = id;
        this.count = count;
        this.user = user;
        this.provider = provider;
        this.date = date;
    }
}
