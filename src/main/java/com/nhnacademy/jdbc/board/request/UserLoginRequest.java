package com.nhnacademy.jdbc.board.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginRequest {


    @NotBlank
    String id;

    @NotBlank
    String pwd;
}