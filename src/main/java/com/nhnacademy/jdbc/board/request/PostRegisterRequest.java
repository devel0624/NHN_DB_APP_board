package com.nhnacademy.jdbc.board.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
public class PostRegisterRequest {

    @Length(min = 2,max = 30)
    String title;

    @NotBlank
    String writerId;

    @Length(min = 1,max = 2000)
    String content;

}
