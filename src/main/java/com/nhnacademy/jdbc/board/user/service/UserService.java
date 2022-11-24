package com.nhnacademy.jdbc.board.user.service;

import com.nhnacademy.jdbc.board.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
     Optional<User> getUser(long id);

     List<User> getAllUser();

     void addUser(User user);

     void modifyUser(String name, long id);

     void deleteUser(long id);

     User getUserByName(String name);
}
