package ksafinalproject.gbt.chat.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OChat {
    private Long id;
    private String message;
    private LocalDateTime created;
}
