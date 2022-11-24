package com.nhnacademy.jdbc.board.user.service.impl;

import com.nhnacademy.jdbc.board.user.domain.User;
import com.nhnacademy.jdbc.board.user.mapper.UserMapper;
import com.nhnacademy.jdbc.board.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author : marco@nhnacademy.com
 * @Date : 17/05/2022
 */

@Service
public class DefaultUserService implements UserService {
    private final UserMapper userMapper;

    public DefaultUserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Optional<User> getUser(long id){
        return userMapper.selectUser(id);
    }

    @Override
    public List<User> getAllUser(){
        return userMapper.selectUsers();
    }

    @Override
    public void addUser(User user){
        userMapper.insertUser(user);
    }

    @Override
    public void modifyUser(String name, long id){
        userMapper.updateNameById(name,id);
    }

    @Override
    public void deleteUser(long id){
        userMapper.deleteById(id);
    }
    @Override
    public User getUserByName(String name) {
        return userMapper.selectUserByName(name);
    }


}

