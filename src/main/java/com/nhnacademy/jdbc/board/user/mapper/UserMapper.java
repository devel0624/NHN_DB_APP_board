package com.nhnacademy.jdbc.board.user.mapper;

import com.nhnacademy.jdbc.board.user.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("Select * from DBAppUsers where id = #{id}")
    Optional<User> selectUser(long id);
    List<User> selectUsers();

    @Insert("Insert into DBAppUsers(username, password, created_at) values (#{user.name},#{user.password},now())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);

    void updateNameById(String name, long id);
    void deleteById(long id);
    @Select("Select * from DBAppUsers where username= #{name}")
    User selectUserByName(String name);
}
