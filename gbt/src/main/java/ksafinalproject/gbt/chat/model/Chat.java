package ksafinalproject.gbt.chat.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NotNull
    @Column(length = 255)
    private String message;
    @NotNull
    private LocalDateTime created;
    @NotNull
    private Long userId;
    @NotNull
    private Long customId;

    @Builder
    public Chat(Long id, String message, LocalDateTime created, Long userId, Long customId) {
        this.id = id;
        this.message = message;
        this.created = created;
        this.userId = userId;
        this.customId = customId;
    }
}
