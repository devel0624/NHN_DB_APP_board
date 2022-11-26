package com.nhnacademy.jdbc.board.reply.domain;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Reply {

    private final long replyId;
    private final long postId;
    private final long writer;
    private final String content;
    private final Timestamp createdAt;

    public Reply(long replyId, long postId, long writer, String content, Timestamp createdAt) {
        this.replyId = replyId;
        this.postId = postId;
        this.writer = writer;
        this.content = content;
        this.createdAt = createdAt;
    }
}
