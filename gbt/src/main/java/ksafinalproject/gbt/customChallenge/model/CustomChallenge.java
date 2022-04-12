package ksafinalproject.gbt.customChallenge.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import ksafinalproject.gbt.user.model.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class CustomChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    @JsonIgnore
    private User creator;
    @NotNull
    @Column(length = 255)
    private String title;
    @NotNull
    private LocalDateTime startDate;
    @NotNull
    private LocalDateTime endDate;
    @Column(length = 50)
    private String method;
    private Long frequency;
    @NotNull
    @Column(length = 50)
    private String summary;
    @NotNull
    @Column(length = 255)
    private String description;
    private Long max;
    @Column(length = 255)
    private String img;

    @Builder
    public CustomChallenge(Long id, User creator, String title, LocalDateTime startDate, LocalDateTime endDate, String method, Long frequency, String summary, String description, Long max, String img) {
        this.id = id;
        this.creator = creator;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.method = method;
        this.frequency = frequency;
        this.summary = summary;
        this.description = description;
        this.max = max;
        this.img = img;
    }
}
