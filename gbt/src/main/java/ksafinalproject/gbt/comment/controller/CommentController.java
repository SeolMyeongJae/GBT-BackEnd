package ksafinalproject.gbt.comment.controller;

import io.swagger.annotations.Api;
import ksafinalproject.gbt.comment.model.Comment;
import ksafinalproject.gbt.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags = {"코멘트"})
@RestController
@CrossOrigin
@RequestMapping("/api/comment")
@RequiredArgsConstructor
@Slf4j
public class CommentController {

    private final CommentService commentService;

    @PostMapping("")
    public int commentSave(@RequestBody Comment comment) {
        try {
            return commentService.saveComment(comment);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @PutMapping("/{id}")
    public int commentUpdate(@RequestBody Comment comment,@PathVariable Long id) {
        try {
            return commentService.updateComment(comment, id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/{id}")
    public Optional<Comment> commentGetById(@PathVariable Long id) {
        try {
            return commentService.getCommentById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @GetMapping("/all")
    public List<Comment> commentGetAll() {
        try {
            return commentService.getAllComment();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/all/desc")
    public List<Comment> commentGetAllByDesc() {
        try {
            return commentService.getAllCommentByDesc();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/all/post/{postId}")
    public List<Comment> commentGetAllByPostId(@PathVariable Long postId) {
        try {
            return commentService.getAllCommentByPostId(postId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}
