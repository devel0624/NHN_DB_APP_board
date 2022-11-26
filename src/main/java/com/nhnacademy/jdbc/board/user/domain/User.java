package com.nhnacademy.jdbc.board.user.domain;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @Author : marco@nhnacademy.com
 * @Date : 17/05/2022
 */

@Getter
public class User {

    private final int userId;
    private final String name;
    private final String pwd;
    private final LocalDateTime createdAt;

    public User(int userId, String name, String pwd, LocalDateTime createdAt) {
        this.userId = userId;
        this.name = name;
        this.pwd = pwd;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
