package ksafinalproject.gbt.post.controller;

import io.swagger.annotations.Api;
import ksafinalproject.gbt.post.model.Post;
import ksafinalproject.gbt.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags = {"포스트"})
@RestController
@CrossOrigin
@RequestMapping("/api/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;

    @PostMapping("")
    public int postSave(@RequestBody Post post) {
        try {
            return postService.savePost(post);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @PutMapping("/{id}")
    public int postUpdate(@RequestBody Post post, @PathVariable Long id) {
        try {
            return postService.updatePost(post, id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/{id}")
    public Optional<Post> postGetById(@PathVariable Long id) {
        try {
            return postService.getPostById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @GetMapping("/all")
    public List<Post> postGetAll() {
        try {
            return postService.getAllPost();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/all/desc")
    public List<Post> postGetAllByDesc() {
        try {
            return postService.getAllPostByDesc();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public int postDeleteById(@PathVariable Long id) {
        try {
            return postService.deletePostById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/all/user/{userId}")
    public List<Post> postGetAllByUserId(@PathVariable Long userId) {
        try {
            return postService.getAllPostByUserId(userId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/all/title/{title}")
    public List<Post> postGetAllByTitleContains(@PathVariable String title) {
        try {
            return postService.getAllPostByTitleContains(title);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/all/author/{author}")
    public List<Post> postGetAllByAuthorContains(@PathVariable String author) {
        try {
            return postService.getAllPostByAuthorContains(author);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/all/category/{category}")
    public List<Post> postGetAllByCategory(@PathVariable String category) {
        try {
            return postService.getAllPostByCategory(category);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}
