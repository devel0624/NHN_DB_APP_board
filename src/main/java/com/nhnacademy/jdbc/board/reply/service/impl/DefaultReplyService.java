package com.nhnacademy.jdbc.board.reply.service.impl;

import com.nhnacademy.jdbc.board.reply.domain.Reply;
import com.nhnacademy.jdbc.board.reply.service.ReplyService;
import com.nhnacademy.jdbc.board.request.ReplyRegisterRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultReplyService implements ReplyService {
    @Override
    public void insertReply(ReplyRegisterRequest replyRegisterRequest) {

    }
    @Override
    public List<Reply> getReplyByPostId(long postId) {
        return null;
    }
}
