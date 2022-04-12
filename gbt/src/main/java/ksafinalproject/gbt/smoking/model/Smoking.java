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
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

}
