package ksafinalproject.gbt.likes.repository;

import ksafinalproject.gbt.likes.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikesRepository extends JpaRepository<Likes, Long> {

    List<Likes> findAllByPostId(Long postId);

    List<Likes> findAllByUserId(Long userId);

}
