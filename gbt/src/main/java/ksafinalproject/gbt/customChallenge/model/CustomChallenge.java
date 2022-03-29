package ksafinalproject.gbt.customChallenge.model;

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
public class CustomChallenge {

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
    @Column(length = 50)
    private String method;
    private Long frequency;
    @NotNull
    @Column(length = 255)
    private String description;
    private Long max;
    @Column(length = 255)
    private String img;

}
