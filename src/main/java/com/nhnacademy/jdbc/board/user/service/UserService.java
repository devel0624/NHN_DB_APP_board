package com.nhnacademy.jdbc.board.user.service;

import com.nhnacademy.jdbc.board.request.UserLoginRequest;
import com.nhnacademy.jdbc.board.user.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
     User login(UserLoginRequest userLoginRequest);
}
