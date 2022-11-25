package com.nhnacademy.jdbc.board.post.domain;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Post {
    private final long  postId;
    private final String title;
    private final String content;
    private final String writer;
    private final Timestamp createdAt;

    public Post(long postId, String title, String writer, String content, Timestamp createdAt) {
        this.postId = postId;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.createdAt = createdAt;
    }
}
