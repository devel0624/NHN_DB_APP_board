package com.nhnacademy.jdbc.board.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
public class UserLoginRequest {

    @Getter
    @Setter
    @NotBlank
    String id;

    @Getter
    @Setter
    @NotBlank
    String pwd;
}