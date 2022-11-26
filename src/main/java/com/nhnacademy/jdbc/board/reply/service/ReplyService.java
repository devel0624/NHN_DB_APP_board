package com.nhnacademy.jdbc.board.reply.service;

import com.nhnacademy.jdbc.board.reply.domain.Reply;
import com.nhnacademy.jdbc.board.request.ReplyRegisterRequest;

import java.util.List;

public interface ReplyService {
    List<Reply> getReplyByPostId(long postId);
    void insertReply(ReplyRegisterRequest replyRegisterRequest);
}
