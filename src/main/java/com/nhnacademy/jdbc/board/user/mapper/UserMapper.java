package com.nhnacademy.jdbc.board.user.mapper;

import com.nhnacademy.jdbc.board.user.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("Select * from JdbcUsers where id = #{id}")
    Optional<User> selectUser(long id);
    List<User> selectUsers();

    @Insert("Insert into JdbcUsers value (#{user.name},#{user.password}")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);
    void updateNameById(String name, long id);
    void deleteById(long id);
    @Select("Select * from JdbcUsers where username= #{name}")
    User selectUserByName(String name);
}
