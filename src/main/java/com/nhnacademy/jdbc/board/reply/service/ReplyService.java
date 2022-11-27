package com.nhnacademy.jdbc.board.reply.service;

import com.nhnacademy.jdbc.board.reply.domain.Reply;
import com.nhnacademy.jdbc.board.valueobject.ReplyVo;
import com.nhnacademy.jdbc.board.request.ReplyRegisterRequest;

import java.util.List;

public interface ReplyService {
    Reply insertReply(ReplyRegisterRequest replyRegisterRequest);
    List<ReplyVo> getRepliesByPostId(long postId);
    void hideReplyById(long replyId);
    void restoreReplyById(long replyId);
}
