package com.nhnacademy.jdbc.board.post.service.impl;

import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.service.PostService;
import com.nhnacademy.jdbc.board.request.PostModifyRequest;
import com.nhnacademy.jdbc.board.request.PostRegisterRequest;
import org.springframework.stereotype.Service;

@Service
public class DefaultPostService implements PostService {
    @Override
    public Post getPostById(String postId) {
        return null;
    }

    @Override
    public Post modifyPost(PostModifyRequest request) {
        return null;
    }

    @Override
    public Post registerPost(PostRegisterRequest request) {
        return null;
    }
}
