//package ksafinalproject.gbt.post.model;
//
//import lombok.*;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@ToString
//@Entity
//@NoArgsConstructor
//public class Post {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @NotNull
//    @Column(length = 255)
//    private String title;
//    @NotNull
//    private String content;
//    @NotNull
//    @Column(length = 20)
//    private String author;
//    @Column(length = 255)
//    private String img;
//    @NotNull
//    @Column(length = 255)
//    private String category;
//    @NotNull
//    private LocalDateTime created;
//    private LocalDateTime updated;
//    @NotNull
//    private Long userId;
//
//    @Builder
//
//    public Post(Long id, String title, String content, String author, String img, String category, LocalDateTime created, LocalDateTime updated, Long userId) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//        this.author = author;
//        this.img = img;
//        this.category = category;
//        this.created = created;
//        this.updated = updated;
//        this.userId = userId;
//    }
//}
