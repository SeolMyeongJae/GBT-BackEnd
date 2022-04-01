package ksafinalproject.gbt.post.service;

import ksafinalproject.gbt.post.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    int savePost(Post post);

    int updatePost(Post post, Long id);

    Optional<Post> getPostById(Long id);

    List<Post> getAllPost();

    List<Post> getAllPostByDesc();

    int deletePostById(Long id);

    List<Post> getAllPostByUserId(Long userid);

    List<Post> getAllPostByTitleContains(String title);

    List<Post> getAllPostByAuthorContains(String author);

    List<Post> getAllPostByCategory(String category);

}
