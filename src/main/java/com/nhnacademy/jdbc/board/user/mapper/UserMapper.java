package com.nhnacademy.jdbc.board.user.mapper;

import com.nhnacademy.jdbc.board.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("Select * from JdbcUsers where id = #{id}")
    Optional<User> selectUser(long id);
    List<User> selectUsers();
    void insertUser(User user);
    void updateNameById(String name, long id);
    void deleteById(long id);
    @Select("Select * from JdbcUsers where username= #{name}")
    User selectUserByName(String name);
}
