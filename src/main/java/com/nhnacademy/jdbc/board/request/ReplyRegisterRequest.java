package com.nhnacademy.jdbc.board.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
public class ReplyRegisterRequest {

    @NotBlank
    String postId;

    @NotBlank
    String writerId;

    @Length(min = 1,max = 500)
    String content;
}
