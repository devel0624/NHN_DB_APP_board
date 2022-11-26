package com.nhnacademy.jdbc.board.reply.domain;

import lombok.Getter;

@Getter
public class Reply {

    private final long replyId;
    private final long postId;
    private final String writer;
    private final String content;

    public Reply(long replyId, long postId, String writer, String content) {
        this.replyId = replyId;
        this.postId = postId;
        this.writer = writer;
        this.content = content;
    }

}
