package com.nhnacademy.jdbc.board.mapper;

import com.nhnacademy.jdbc.board.reply.domain.Reply;
import com.nhnacademy.jdbc.board.valueobject.ReplyVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ReplyMapper {

    @Select("Select R.reply_id, R.user_id, U.username, R.content, R.created_at, R.available " +
            "       from DBAppReply AS R\n" +
            "           INNER join DBAppUsers AS U ON R.user_id = U.user_id\n" +
            "       where post_id = #{postId}")
    List<ReplyVo> getRepliesByPostId(long postId);

    @Insert("insert into DBAppReply(post_id, user_id, content,created_at) VALUES (#{postId},#{writer},#{content},#{createdAt})")
    void insertRepliesByPostId(Reply reply);

    @Update("UPDATE DBAppReply SET available = 0 WHERE reply_id = #{replyId}")
    int hideReplyById(long replyId);
    //일반 사용자에게는 노출되지 않도록 boolean 값을 사용해 숨기기

    @Update("UPDATE DBAppReply SET available = 1 WHERE reply_id = #{replyId}")
    int restoreReplyById(long replyId);

}
