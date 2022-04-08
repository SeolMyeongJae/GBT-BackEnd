package ksafinalproject.gbt.postImg.service;

import ksafinalproject.gbt.postImg.dto.IPostImg;
import ksafinalproject.gbt.postImg.model.PostImg;

import java.util.List;
import java.util.Optional;

public interface PostImgService {

    int savePostImg(IPostImg iPostImg);

    int updatePostImg(IPostImg iPostImg, Long id);

    Optional<PostImg> getPostImgById(Long id);

    List<PostImg> getAllPostImg();

    int deletePostImgById(Long id);

    List<PostImg> getAllPostImgByPostId(Long postId);
}
