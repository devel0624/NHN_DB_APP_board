package com.nhnacademy.jdbc.board.post.service;

import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.domain.PostVo;
import com.nhnacademy.jdbc.board.request.PostModifyRequest;
import com.nhnacademy.jdbc.board.request.PostRegisterRequest;

public interface PostService {
    PostVo getPostById(long postId);
    Post modifyPost(PostModifyRequest request);
    Post registerPost(PostRegisterRequest request);
}
