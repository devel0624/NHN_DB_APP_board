package com.nhnacademy.jdbc.board.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SessionUser {
    String name;
    long id;
    boolean admin;
}
