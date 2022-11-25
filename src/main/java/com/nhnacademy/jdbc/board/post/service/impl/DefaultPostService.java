package com.nhnacademy.jdbc.board.post.service.impl;

import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class DefaultPostService implements PostService {
    @Override
    public Post getPostById(String postId) {
        return null;
    }
}
