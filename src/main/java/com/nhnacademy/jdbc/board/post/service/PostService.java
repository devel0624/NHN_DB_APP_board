package com.nhnacademy.jdbc.board.post.service;

import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.request.PostModifyRequest;
import com.nhnacademy.jdbc.board.request.PostRegisterRequest;

public interface PostService {
    Post getPostById(long postId);
    Post modifyPost(PostModifyRequest request);
    Post registerPost(PostRegisterRequest request);
}
