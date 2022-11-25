package com.nhnacademy.jdbc.board.post.service;

import com.nhnacademy.jdbc.board.post.domain.Post;

public interface PostService {
    Post getPostById(String postId);
}
