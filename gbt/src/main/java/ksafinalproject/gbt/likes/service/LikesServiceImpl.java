package ksafinalproject.gbt.likes.service;

import ksafinalproject.gbt.likes.model.Likes;
import ksafinalproject.gbt.likes.repository.LikesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LikesServiceImpl implements LikesService {

    private final LikesRepository likeRepository;

    @Override
    public int saveLike(Likes like) {
        log.info("save like : {}", like);
        try {
            Optional<Likes> like2 = likeRepository.findByPostIdAndUserId(like.getPostId(), like.getUserId());
            if(like2.isPresent()) {
                likeRepository.deleteById(like2.get().getId());
                return 2;
            }
            likeRepository.save(like);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public Optional<Likes> getLikeById(Long id) {
        log.info("find like by id : {}", id);
        try {
            return likeRepository.findById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<Likes> getLikeByPostIdAndUserId(Long postId, Long userId) {
        log.info("find like by post id : {}, user id : {}", postId, userId);
        try {
            return likeRepository.findByPostIdAndUserId(postId, userId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Likes> getAllLike() {
        log.info("find all like");
        try {
            return likeRepository.findAll();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public int deleteLikeById(Long id) {
        log.info("delete like by id");
        try {
            likeRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public List<Likes> getAllLikeByPostId(Long postId) {
        log.info("find all like by post id : {}", postId);
        try {
            return likeRepository.findAllByPostId(postId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<Likes> getAllLikeByUserId(Long userId) {
        log.info("find all like by user id : {}", userId);
        try {
            return likeRepository.findAllByUserId(userId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}
