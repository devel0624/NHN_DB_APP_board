package com.nhnacademy.jdbc.board.web;

import com.nhnacademy.jdbc.board.exception.ValidationFailedException;
import com.nhnacademy.jdbc.board.request.UserLoginRequest;
import com.nhnacademy.jdbc.board.user.domain.User;
import com.nhnacademy.jdbc.board.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String redicretLoginForm(){
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute UserLoginRequest userLoginRequest,
                        BindingResult bindingResult,
                        Model model){

        if(bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult);
        }

        User user = userService.getUserByName(userLoginRequest.getName());

        model.addAttribute("user",user);

        return "post/postList";
    }
}
