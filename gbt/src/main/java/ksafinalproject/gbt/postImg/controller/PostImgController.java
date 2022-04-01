package ksafinalproject.gbt.postImg.controller;

import io.swagger.annotations.Api;
import ksafinalproject.gbt.postImg.model.PostImg;
import ksafinalproject.gbt.postImg.service.PostImgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags = {"포스트 이미지"})
@RestController
@CrossOrigin
@RequestMapping("/api/post-img")
@RequiredArgsConstructor
@Slf4j
public class PostImgController {

    private final PostImgService postImgService;

    @PostMapping("")
    public int postImgSave(@RequestBody PostImg postImg) {
        try {
            return postImgService.savePostImg(postImg);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @PutMapping("/{id}")
    public int postImgUpdate(@RequestBody PostImg postImg, @PathVariable Long id) {
        try {
            return postImgService.updatePostImg(postImg, id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/{id}")
    public Optional<PostImg> postImgGetById(@PathVariable Long id) {
        try {
            return postImgService.getPostImgById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @GetMapping("/all")
    public List<PostImg> postImgGetAll() {
        try {
            return postImgService.getAllPostImg();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public int postImgDeleteById(@PathVariable Long id) {
        try {
            return postImgService.deletePostImgById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/all/post/{postId}")
    public List<PostImg> postImgGetAllByPostId(@PathVariable Long postId) {
        try {
            return postImgService.getAllPostImgByPostId(postId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

}
