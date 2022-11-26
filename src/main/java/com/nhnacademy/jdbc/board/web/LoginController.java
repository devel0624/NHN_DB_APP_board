package com.nhnacademy.jdbc.board.web;

import com.nhnacademy.jdbc.board.CookieManager;
import com.nhnacademy.jdbc.board.exception.ValidationFailedException;
import com.nhnacademy.jdbc.board.interceptor.LoginInterceptor;
import com.nhnacademy.jdbc.board.request.UserLoginRequest;
import com.nhnacademy.jdbc.board.user.domain.User;
import com.nhnacademy.jdbc.board.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Slf4j
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
                        HttpServletResponse response,
                        BindingResult bindingResult,
                        Model model){

        if(bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult);
        }

        User user = userService.login(userLoginRequest);

        CookieManager.generateLoginSession(response,user);

        model.addAttribute("user",user);

        return "post/list";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){

        CookieManager.removeLoginSession(request, response);

        return "redirect:/post/list";
    }





}
