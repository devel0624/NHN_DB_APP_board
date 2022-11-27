package com.nhnacademy.jdbc.board.mapper;

import com.nhnacademy.jdbc.board.user.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("Select * from DBAppUsers where user_id = #{id}")
    Optional<User> selectUser(long id);

    @Select("Select admin from DBAppUsers where user_id = #{id}")
    boolean isHeAdmin(long id);
    List<User> selectUsers();
    @Insert("Insert into DBAppUsers(username, password, created_at) values (#{user.name},#{user.password},now())")
    int insertUser(User user);
    void updateNameById(String name, long id);
    void deleteById(long id);
    @Select("Select * from DBAppUsers where username= #{name}")
    User selectUserByName(String name);
}
