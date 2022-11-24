package com.nhnacademy.jdbc.board.user.domain;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @Author : marco@nhnacademy.com
 * @Date : 17/05/2022
 */

@Getter
public class User {
    private final int id;
    private final String name;
    private final String pwd;
    private final LocalDateTime createdAt;

    public User(int id, String name, String pwd, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + pwd + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
