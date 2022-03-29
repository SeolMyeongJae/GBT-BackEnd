package ksafinalproject.gbt.challenge.model;

import javax.validation.constraints.NotNull;
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
    @NotNull
    @Column(length = 255)
    private String title;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;
    @NotNull
    @Column(length = 50)
    private String method;
    @NotNull
    private Long frequency;
    @NotNull
    @Column(length = 255)
    private String description;
    @NotNull
    private Long max;
    @NotNull
    @Column(length = 255)
    private String img;

}
