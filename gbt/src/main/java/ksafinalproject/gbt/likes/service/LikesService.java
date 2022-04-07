package ksafinalproject.gbt.likes.service;

import ksafinalproject.gbt.likes.dto.ILikes;
import ksafinalproject.gbt.likes.model.Likes;

import java.util.List;
import java.util.Optional;

public interface LikesService {

    int saveLike(ILikes iLike);

    Optional<Likes> getLikeById(Long id);

    Optional<Likes> getLikeByPostIdAndUserId(Long postId, Long userId);

    List<Likes> getAllLike();

    int deleteLikeById(Long id);

    List<Likes> getAllLikeByPostId(Long postId);

    List<Likes> getAllLikeByUserId(Long userId);



}
