package com.nhnacademy.jdbc.board.like.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LikeMapper {

    @Select("SELECT count(*) FROM DBAppLikeAtPost WHERE id = #{postId}")
    int getLikeCountByPostId(long postId);

    @Insert("INSERT into DBAppLikeAtPost Value (#{postId},(#{userId})")
    void addLikeAtPostWithUserId(long postId,long userId);

    @Delete("DELETE FROM DBAppLikeAtPost WHERE post_id= #{postId} , user_id = (#{userId})")
    void removeLikeAtPostWithUserId(long postId,long userId);
}
