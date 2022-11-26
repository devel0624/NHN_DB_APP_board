package com.nhnacademy.jdbc.board.post;

import com.nhnacademy.jdbc.board.post.domain.Post;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PostMapper {

    @Select("Select * from DBAppPosts where post_id = #{postId}")
    Post selectPostById(long postId);

    @Insert("insert into DBAppPosts(title, content, user_id, created_at) VALUES (#{title},#{content},#{writer},#{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "postId")
    int insertPost(Post post);

    @Delete("Delete from DBAppPosts where post_id = #{postId}")
    int deletePostById(long postId);
}
