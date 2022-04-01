package ksafinalproject.gbt.postImg.service;

import ksafinalproject.gbt.postImg.model.PostImg;
import ksafinalproject.gbt.postImg.repository.PostImgRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostImgServiceImpl implements PostImgService {

    private final PostImgRepository postImgRepository;

    @Override
    public int savePostImg(PostImg postImg) {
        log.info("save post img : {}", postImg);
        try {
            postImgRepository.save(postImg);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Transactional
    @Override
    public int updatePostImg(PostImg postImg, Long id) {
        log.info("update post img by id : {}", id);
        try {
            PostImg postImg2 = postImgRepository.findById(id).orElseThrow();
            postImg2.setUrl(postImg.getUrl());
            postImg2.setPostId(postImg.getPostId());
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return 0;
        }
    }

    @Override
    public Optional<PostImg> getPostImgById(Long id) {
        log.info("find post img by id");
        try {
            return postImgRepository.findById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<PostImg> getAllPostImg() {
        log.info("find all post img");
        try {
            return postImgRepository.findAll();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public int deletePostImgById(Long id) {
        log.info("delete post img by id : {}", id);
        try {
            postImgRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public List<PostImg> getAllPostImgByPostId(Long postId) {
        log.info("find all post img by user id : {}", postId);
        try {
            return postImgRepository.findAllByPostId(postId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}
