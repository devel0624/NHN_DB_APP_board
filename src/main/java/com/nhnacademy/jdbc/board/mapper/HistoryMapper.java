package com.nhnacademy.jdbc.board.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HistoryMapper {
    @Insert("INSERT into DBAppPostModifyHistory(post_id, modify_at, modify_user_id) values(#{postId},now(),#{userId})\n" +
            "   ON DUPLICATE KEY UPDATE modify_at=now(), modify_user_id=#{userId}")
    void insertModifyHistory(@Param("postId") long postId,@Param("userId") long writerId);
}
