package com.nhnacademy.jdbc.board.post.service.impl;

import com.nhnacademy.jdbc.board.post.domain.PostVo;
import com.nhnacademy.jdbc.board.post.mapper.PostMapper;
import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.service.PostService;
import com.nhnacademy.jdbc.board.request.PostModifyRequest;
import com.nhnacademy.jdbc.board.request.PostRegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Slf4j
@Service
public class DefaultPostService implements PostService {

    private final PostMapper postMapper;

    public DefaultPostService(PostMapper postMapper) {
        this.postMapper = postMapper;
    }


    @Override
    public PostVo getPostById(long postId) {
        return postMapper.selectPostById(postId);
    }

    @Override
    public Post modifyPost(PostModifyRequest request) {
        return null;
    }

    @Override
    public Post registerPost(PostRegisterRequest request) {
        Post post = new Post(0,request.getTitle(),request.getContent(),Long.parseLong(request.getWriterId()), Timestamp.valueOf(LocalDateTime.now()));

        postMapper.insertPost(post);

        return post;
    }
}
