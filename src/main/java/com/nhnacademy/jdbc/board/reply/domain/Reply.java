package com.nhnacademy.jdbc.board.reply.domain;

public class Reply {

    private final String writer;
    private final String content;

    public Reply(String writer, String content) {
        this.writer = writer;
        this.content = content;
    }
}
