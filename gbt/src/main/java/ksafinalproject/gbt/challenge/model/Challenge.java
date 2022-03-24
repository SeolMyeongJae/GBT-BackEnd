package ksafinalproject.gbt.challenge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255)
    private String title;
    private Date startDate;
    private Date endDate;
    @Column(length = 50)
    private String method;
    private Long frequency;
    @Column(length = 255)
    private String description;
    private Long max;
    @Column(length = 255)
    private String img;

}
