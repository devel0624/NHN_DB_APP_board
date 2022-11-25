package com.nhnacademy.jdbc.board.user.service.impl;

import com.nhnacademy.jdbc.board.exception.InvalidPasswordException;
import com.nhnacademy.jdbc.board.exception.UserNotFoundException;
import com.nhnacademy.jdbc.board.request.UserLoginRequest;
import com.nhnacademy.jdbc.board.user.domain.User;
import com.nhnacademy.jdbc.board.user.mapper.UserMapper;
import com.nhnacademy.jdbc.board.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author : marco@nhnacademy.com
 * @Date : 17/05/2022
 */

@Slf4j
@Service
public class DefaultUserService implements UserService {
    private final UserMapper userMapper;

    public DefaultUserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public User login(UserLoginRequest userLoginRequest) {

        String id = userLoginRequest.getId();
        String pwd = userLoginRequest.getPwd();

        Optional<User> user = Optional.ofNullable(userMapper.selectUserByName(id));

        if (user.isPresent()) {
            if (user.get().getPwd().equals(pwd)) {
                return user.get();
            } else {
                throw new InvalidPasswordException();
            }
        } else {
            throw new UserNotFoundException();
        }
    }

}

