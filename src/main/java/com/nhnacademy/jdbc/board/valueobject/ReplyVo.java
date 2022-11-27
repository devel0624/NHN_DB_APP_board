package com.nhnacademy.jdbc.board.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class ReplyVo {

    long replyId;
    long userId;
    String writer;
    String content;
    Timestamp createdAt;
    boolean available;
}
