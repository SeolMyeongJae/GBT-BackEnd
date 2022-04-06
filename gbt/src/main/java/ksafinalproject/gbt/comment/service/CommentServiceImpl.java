package ksafinalproject.gbt.comment.service;

import ksafinalproject.gbt.comment.model.Comment;
import ksafinalproject.gbt.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public int saveComment(Comment comment) {
        log.info("save comment : {}", comment);
        try {
            commentRepository.save(Comment.builder()
                    .id(comment.getId())
                    .comment(comment.getComment())
                    .author(comment.getAuthor())
                    .created(LocalDateTime.now())
                    .postId(comment.getPostId())
                    .build());
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Transactional
    @Override
    public int updateComment(Comment comment, Long id) {
        log.info("update comment : {}, id : {}", comment, id);
        try {
            Comment comment2 = commentRepository.findById(id).orElseThrow();
            comment2.setComment(comment.getComment());
            comment2.setAuthor(comment.getAuthor());
            comment2.setUpdated(LocalDateTime.now());
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public Optional<Comment> getCommentById(Long id) {
        log.info("find comment by id : {}", id);
        try {
            return commentRepository.findById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Comment> getAllComment() {
        log.info("find all comment");
        try {
            return commentRepository.findAll();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<Comment> getAllCommentByDesc() {
        log.info("find all comment by desc");
        try {
            Sort sort = Sort.by(Sort.Direction.DESC, "id");
            return commentRepository.findAll(sort);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public int deleteCommentById(Long id) {
        log.info("delete comment by id : {}", id);
        try {
            commentRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public List<Comment> getAllCommentByPostId(Long postId) {
        log.info("find all comment by post id : {}", postId);
        try {
            Sort sort = Sort.by(Sort.Direction.DESC, "id");
            return commentRepository.findAllByPostId(postId, sort);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}
