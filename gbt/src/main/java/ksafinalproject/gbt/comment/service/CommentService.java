package ksafinalproject.gbt.comment.service;

import ksafinalproject.gbt.comment.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    int saveComment(Comment comment);

    int updateComment(Comment comment, Long id);

    Optional<Comment> getCommentById(Long id);

    List<Comment> getAllComment();

    List<Comment> getAllCommentByDesc();

    int deleteCommentById(Long id);

    List<Comment> getAllCommentByPostId(Long postId);

}
