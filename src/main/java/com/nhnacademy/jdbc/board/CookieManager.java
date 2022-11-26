package com.nhnacademy.jdbc.board;

import com.nhnacademy.jdbc.board.exception.LoginSessionNotExistException;
import com.nhnacademy.jdbc.board.interceptor.LoginInterceptor;
import com.nhnacademy.jdbc.board.user.domain.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

@Slf4j
public class CookieManager {

    private CookieManager() {
    }

    private static final String COOKIE_NAME = "LoginSession";

    public static void generateLoginSession(HttpServletResponse response, User user){

        Cookie cookie = new Cookie(COOKIE_NAME,user.getName() +"|"+ user.getUserId());
        cookie.setMaxAge(20000);
        response.addCookie(cookie);

        log.info("Generate Login Session Cookie");

    }

    public static Cookie getCookie(HttpServletRequest request) {

        Optional<Cookie> cookie = Arrays.stream(request.getCookies())
                .filter(x->x.getName().equals(COOKIE_NAME)).findFirst().stream().findFirst();

        if(cookie.isEmpty()){
            throw new LoginSessionNotExistException();
        }

        return cookie.get();
    }

    public static void removeLoginSession(HttpServletRequest request,
                                          HttpServletResponse response){

        Cookie cookie = getCookie(request);

        cookie.setValue(null);
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        log.info("Delete Login Session Cookie");
    }

}
