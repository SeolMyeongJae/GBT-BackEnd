package ksafinalproject.gbt.smoking.model;

import javax.validation.constraints.NotNull;
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
    @NotNull
    private Long userId;
    @NotNull
    @Column(length = 10)
    private String provider;

    @Builder
    public Smoking(Long id, Long count, LocalDate date, Long userId, String provider) {
        this.id = id;
        this.count = count;
        this.userId = userId;
        this.provider = provider;
        this.date = date;
    }
}
