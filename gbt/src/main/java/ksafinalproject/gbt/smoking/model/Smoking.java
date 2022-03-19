package ksafinalproject.gbt.smoking.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Smoking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long count;
    private Date date;
    private Long userId;
    @Column(length = 10)
    private String provider;

    @Builder
    public Smoking(Long id, Long count, Date date, Long userId, String provider, LocalDateTime createDate) {
        this.id = id;
        this.count = count;
        this.userId = userId;
        this.provider = provider;
        this.date = date;
    }
}
