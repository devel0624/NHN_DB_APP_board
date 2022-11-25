package com.nhnacademy.jdbc.board.interceptor;

import com.nhnacademy.jdbc.board.exception.LoginSessionNotExist;
import com.nhnacademy.jdbc.board.user.domain.User;
import com.nhnacademy.jdbc.board.web.LoginController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            try{
                Cookie cookie = getCookie(request);
                log.info("Login Session Exist : " + cookie.getValue());
            }catch (LoginSessionNotExist e){
                response.sendRedirect("/login");
            }

            return true;
        }

    public static Cookie getCookie(HttpServletRequest request) {

        String cookieName = "LoginSession";

        Optional<Cookie> cookie = Arrays.stream(request.getCookies())
                .filter(x->x.getName().equals(cookieName)).findFirst().stream().findFirst();

        if(cookie.isEmpty()){
            throw new LoginSessionNotExist();
        }

        return cookie.get();
    }


}
