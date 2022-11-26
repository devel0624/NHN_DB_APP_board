package com.nhnacademy.jdbc.board.post.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class PostVo {

    long  postId;
    String title;
    String content;
    long writerId;
    String writerName;
    Timestamp createdAt;
}
