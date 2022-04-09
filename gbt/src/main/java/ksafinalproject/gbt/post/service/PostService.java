package ksafinalproject.gbt.post.service;

import ksafinalproject.gbt.post.dto.IPost;
import ksafinalproject.gbt.post.dto.OPost;
import ksafinalproject.gbt.post.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    int savePost(IPost iPost);

    int updatePost(IPost iPost, Long id);

    Optional<Post> getPostById(Long id);

    List<OPost> getAllPost();

    List<OPost> getAllPostByDesc();

    int deletePostById(Long id);

    List<OPost> getAllPostByUserId(Long userid);

    List<OPost> getAllPostByTitleContains(String title);

    List<OPost> getAllPostByAuthorContains(String author);

    List<OPost> getAllPostByCategory(String category);

}
