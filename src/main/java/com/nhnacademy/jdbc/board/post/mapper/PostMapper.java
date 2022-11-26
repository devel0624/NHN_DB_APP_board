package com.nhnacademy.jdbc.board.post.mapper;

import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.domain.PostVo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PostMapper {

//    @Select("Select * from DBAppPosts where post_id = #{postId}")
//    Post selectPostById(long postId);

    @Select("Select P.post_id, P.title, P.content, P.user_id, U.username, P.created_at \n" +
            "    from DBAppPosts AS P\n" +
            "        INNER join DBAppUsers AS U ON P.user_id = U.user_id\n" +
            "    where post_id = #{postId}")
    PostVo selectPostById(long postId);

    @Insert("insert into DBAppPosts(title, content, user_id, created_at) VALUES (#{title},#{content},#{writer},#{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "postId")
    int insertPost(Post post);

    @Delete("Delete from DBAppPosts where post_id = #{postId}")
    int deletePostById(long postId);
}
