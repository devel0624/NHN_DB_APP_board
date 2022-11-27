package com.nhnacademy.jdbc.board.post.service;

import com.nhnacademy.jdbc.board.page.Page;
import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.valueobject.PostVo;
import com.nhnacademy.jdbc.board.request.PostModifyRequest;
import com.nhnacademy.jdbc.board.request.PostRegisterRequest;

import java.util.List;

public interface PostService {
    PostVo getPostById(long postId);
    Post modifyPost(PostModifyRequest request);
    Post registerPost(PostRegisterRequest request);
    List<PostVo> getAllPost();
    Page<PostVo> getAllPostByPage(long page);
    void hidePostById(long postId);
    void restorePostById(long postId);
}
