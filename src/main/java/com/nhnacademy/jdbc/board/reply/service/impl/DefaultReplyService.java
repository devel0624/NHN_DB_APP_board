package com.nhnacademy.jdbc.board.reply.service.impl;

import com.nhnacademy.jdbc.board.reply.domain.Reply;
import com.nhnacademy.jdbc.board.valueobject.ReplyVo;
import com.nhnacademy.jdbc.board.mapper.ReplyMapper;
import com.nhnacademy.jdbc.board.reply.service.ReplyService;
import com.nhnacademy.jdbc.board.request.ReplyRegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class DefaultReplyService implements ReplyService {

    private final ReplyMapper replyMapper;

    public DefaultReplyService(ReplyMapper replyMapper) {
        this.replyMapper = replyMapper;
    }

    @Override
    public Reply insertReply(ReplyRegisterRequest replyRegisterRequest) {
        Reply reply = new Reply(0,
                Long.parseLong(replyRegisterRequest.getPostId()),
                Long.parseLong(replyRegisterRequest.getWriterId()),
                replyRegisterRequest.getContent(),
                Timestamp.valueOf(LocalDateTime.now()));

        replyMapper.insertRepliesByPostId(reply);

        log.info("Insert Complete Reply : " + reply.getReplyId());
        return reply;
    }
    @Override
    public List<ReplyVo> getRepliesByPostId(long postId) {
        return replyMapper.getRepliesByPostId(postId);
    }

    @Override
    public void hideReplyById(long replyId) {
        replyMapper.hideReplyById(replyId);
        log.info("Delete Complete Reply : " + replyId);
    }

    @Override
    public void restoreReplyById(long replyId) {
        replyMapper.restoreReplyById(replyId);
        log.info("Restore Complete Reply : " + replyId);
    }
}
