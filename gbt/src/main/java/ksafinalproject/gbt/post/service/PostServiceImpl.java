package ksafinalproject.gbt.post.service;

import ksafinalproject.gbt.post.dto.IPost;
import ksafinalproject.gbt.post.model.Post;
import ksafinalproject.gbt.post.repository.PostRepository;
import ksafinalproject.gbt.user.repository.UserRepository;
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
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public int savePost(IPost iPost) {
        log.info("save post : {}", iPost);
        try {
            postRepository.save(Post.builder()
                    .id(iPost.getId())
                    .title(iPost.getTitle())
                    .content(iPost.getContent())
                    .author(iPost.getAuthor())
                    .img(iPost.getImg())
                    .category(iPost.getCategory())
                    .created(LocalDateTime.now())
                    .user(userRepository.findById(iPost.getUserId()).orElseThrow())
                    .build());
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    @Transactional
    public int updatePost(IPost iPost, Long id) {
        log.info("update post : {}, id : {}", iPost, id);
        try {
            Post post2 = postRepository.findById(id).orElseThrow();
            post2.setTitle(iPost.getTitle());
            post2.setContent(iPost.getContent());
            post2.setAuthor(iPost.getAuthor());
            post2.setImg(iPost.getImg());
            post2.setCategory(iPost.getCategory());
            post2.setUpdated(LocalDateTime.now());
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        log.info("find post by id : {}", id);
        try {
            return postRepository.findById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Post> getAllPost() {
        log.info("find all post");
        try {
            return postRepository.findAll();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<Post> getAllPostByDesc() {
        log.info("find all post by desc");
        try {
            Sort sort = Sort.by(Sort.Direction.DESC, "id");
            return postRepository.findAll(sort);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public int deletePostById(Long id) {
        log.info("delete post by id : {}", id);
        try {
            postRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public List<Post> getAllPostByUserId(Long userId) {
        log.info("find all post by user id : {}", userId);
        try {
            Sort sort = Sort.by(Sort.Direction.DESC, "id");
            return postRepository.findAllByUserId(userId, sort);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<Post> getAllPostByTitleContains(String title) {
        log.info("find all post by title contains : {}", title);
        try {
            Sort sort = Sort.by(Sort.Direction.DESC, "id");
            return postRepository.findAllByTitleContains(title, sort);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<Post> getAllPostByAuthorContains(String author) {
        log.info("find all post by author contains : {}", author);
        try {
            Sort sort = Sort.by(Sort.Direction.DESC, "id");
            return postRepository.findAllByAuthorContains(author, sort);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<Post> getAllPostByCategory(String category) {
        log.info("find all post by category : {}", category);
        try {
            Sort sort = Sort.by(Sort.Direction.DESC, "id");
            return postRepository.findAllByCategory(category, sort);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}
