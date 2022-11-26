package com.nhnacademy.jdbc.board.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class PostModifyRequest{

    @Length(min = 2,max = 30)
    String title;

    @NotBlank
    long writerId;

    @Length(min = 1,max = 2000)
    String content;

}
