package com.nhnacademy.jdbc.board.post.service.impl;

import com.nhnacademy.jdbc.board.page.Page;
import com.nhnacademy.jdbc.board.valueobject.PostVo;
import com.nhnacademy.jdbc.board.mapper.PostMapper;
import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.service.PostService;
import com.nhnacademy.jdbc.board.request.PostModifyRequest;
import com.nhnacademy.jdbc.board.request.PostRegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class DefaultPostService implements PostService {

    private final PostMapper postMapper;

    private static final long PAGE_SIZE = 20;
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

    @Override
    public List<PostVo> getAllPost() {
        return null;
    }
    @Override
    public Page<PostVo> getAllPostByPage(long page) {
        List<PostVo> posts = postMapper.selectAllPostsWithPages(page,PAGE_SIZE);
        long totalCount = postMapper.totalPostCount();
        long pageCount;

        if(totalCount % PAGE_SIZE == 0){
            pageCount = totalCount/PAGE_SIZE;
        }else {
            pageCount = totalCount/PAGE_SIZE;
            pageCount++;
        }

        return new Page<>(posts,pageCount);
    }

    @Override
    public void hidePostById(long postId) {
        postMapper.hidePostById(postId);
        log.info("Delete Complete Post : " + postId);
    }

    @Override
    public void restorePostById(long postId) {
        postMapper.restorePostById(postId);
        log.info("Restore Complete Post : " + postId);
    }
}
