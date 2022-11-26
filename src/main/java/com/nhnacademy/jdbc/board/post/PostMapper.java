package com.nhnacademy.jdbc.board.post;

import com.nhnacademy.jdbc.board.post.domain.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PostMapper {

    @Insert("insert into DBAppPosts(title, content, user_id, created_at) VALUES (#{title},#{content},#{writerId});")
    int insertPost(String title, String content, long writerId);

    @Select("Select * from DBAppPosts where post_id = #{postId}")
    Post selectPostById(long postId);
}
