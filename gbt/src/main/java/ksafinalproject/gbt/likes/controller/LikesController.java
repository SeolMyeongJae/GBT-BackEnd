package ksafinalproject.gbt.likes.controller;

import io.swagger.annotations.Api;
import ksafinalproject.gbt.likes.model.Likes;
import ksafinalproject.gbt.likes.service.LikesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags = {"라이크"})
@RestController
@CrossOrigin
@RequestMapping("/api/likes")
@RequiredArgsConstructor
@Slf4j
public class LikesController {

    private final LikesService likeService;

    @PostMapping("")
    public int likeSave(@RequestBody Likes like) {
        try {
            return likeService.saveLike(like);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/{id}")
    public Optional<Likes> likeGetById(@PathVariable Long id) {
        try {
            return likeService.getLikeById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @GetMapping("/all")
    public List<Likes> likeGetAll() {
        try {
            return likeService.getAllLike();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/all/post/{postId}")
    public List<Likes> likeGetAllByPostId(@PathVariable Long postId) {
        try {
            return likeService.getAllLikeByPostId(postId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/all/user/{userId}")
    public List<Likes> likeGetAllByUserId(@PathVariable Long userId) {
        try {
            return likeService.getAllLikeByUserId(userId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}
