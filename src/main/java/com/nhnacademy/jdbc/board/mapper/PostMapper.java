package com.nhnacademy.jdbc.board.mapper;

import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.request.PostModifyRequest;
import com.nhnacademy.jdbc.board.valueobject.PostVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {

    @Select("Select P.post_id, P.title, P.content, P.user_id, U.username, P.created_at,\n" +
            "       count(case when R.available = 1 then 1 end) as count ,P.available, US.username, H.modify_at\n" +
            "           from DBAppPosts AS P\n" +
            "               INNER join DBAppUsers AS U ON P.user_id = U.user_id\n" +
            "                   Left join DBAppReply AS R ON R.post_id = P.post_id\n" +
            "                   Left join DBAppPostModifyHistory AS H On H.post_id = P.post_id\n" +
            "                   Left JOIN DBAppUsers AS US ON H.modify_user_id = US.user_id\n" +
            "           where P.post_id = ${postId}\n" +
            "               GROUP BY P.post_id, R.post_id")
    PostVo selectPostById(long postId);

    @Select("Select P.post_id, P.title, P.content, P.user_id, P.created_at\n" +
            "       from DBAppPosts AS P\n" +
            "       where P.post_id = ${postId}")
    Post selectModifyPostById(long postId);

    @Select("Select P.post_id, P.title, P.content, P.user_id, U.username, P.created_at,\n" +
            "       count(case when R.available = 1 then 1 end) as count ,P.available, US.username, H.modify_at\n" +
            "           from DBAppPosts AS P\n" +
            "               INNER join DBAppUsers AS U ON P.user_id = U.user_id\n" +
            "                   Left join DBAppReply AS R ON R.post_id = P.post_id\n" +
            "                   Left join DBAppPostModifyHistory AS H On H.post_id = P.post_id\n" +
            "                   Left JOIN DBAppUsers AS US ON H.modify_user_id = US.user_id\n" +
            "       GROUP BY P.post_id, R.post_id\n"+
            "           ORDER BY post_id LIMIT #{size} OFFSET #{offset}")
    List<PostVo> selectAllPostsWithPages(@Param("offset") long page,@Param("size") long size);

    @Select("SELECT count(*) FROM DBAppPosts")
    long totalPostCount();

    @Insert("insert into DBAppPosts(title, content, user_id, created_at) VALUES (#{title},#{content},#{writer},#{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "postId")
    void insertPost(Post post);

    @Update("UPDATE DBAppPosts SET available = 0 WHERE post_id = #{postId}")
    void hidePostById(long postId);
    //일반 사용자에게는 노출되지 않도록 boolean 값을 사용해 숨기기

    @Update("UPDATE DBAppPosts SET available = 1 WHERE post_id = #{postId}")
    void restorePostById(long postId);

    @Update("UPDATE DBAppPosts SET title = #{title} , content = #{content} WHERE post_id = #{postId} ")
    void updatePostById(PostModifyRequest request);
}
