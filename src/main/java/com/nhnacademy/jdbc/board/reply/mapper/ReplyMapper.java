package com.nhnacademy.jdbc.board.reply.mapper;

import com.nhnacademy.jdbc.board.reply.domain.Reply;
import com.nhnacademy.jdbc.board.reply.domain.ReplyVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReplyMapper {

    @Select("Select R.reply_id, R.user_id, U.username, R.content, R.created_at from DBAppReply AS R\n" +
            "         INNER join DBAppUsers AS U ON R.user_id = U.user_id\n" +
            "         where post_id = #{postId}")
    List<ReplyVo> getRepliesByPostId(long postId);

    @Insert("insert into DBAppReply(post_id, user_id, content,created_at) VALUES (#{postId},#{writer},#{content},#{createdAt})")
    int insertRepliesByPostId(Reply reply);

}
