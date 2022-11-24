package com.nhnacademy.jdbc.board.request;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class UserLoginRequest {

    @NotBlank
    String name;

    @NotBlank
    String pwd;
}
