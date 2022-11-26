package com.nhnacademy.jdbc.board.post.service.impl;

import com.nhnacademy.jdbc.board.post.PostMapper;
import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.service.PostService;
import com.nhnacademy.jdbc.board.request.PostModifyRequest;
import com.nhnacademy.jdbc.board.request.PostRegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DefaultPostService implements PostService {

    private final PostMapper postMapper;

    public DefaultPostService(PostMapper postMapper) {
        this.postMapper = postMapper;
    }


    @Override
    public Post getPostById(long postId) {
        return postMapper.selectPostById(postId);
    }

    @Override
    public Post modifyPost(PostModifyRequest request) {
        return null;
    }

    @Override
    public int registerPost(PostRegisterRequest request) {
        return postMapper.insertPost(request.getTitle(),request.getContent(),request.getWriterId());
    }
}
