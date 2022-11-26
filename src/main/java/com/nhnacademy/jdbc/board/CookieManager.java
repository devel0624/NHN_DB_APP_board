package com.nhnacademy.jdbc.board;

import com.nhnacademy.jdbc.board.exception.NotDetectedAnySessionException;
import com.nhnacademy.jdbc.board.exception.LoginSessionNotExistException;
import com.nhnacademy.jdbc.board.user.domain.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Objects;
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
        log.info("cookies");


        if(Objects.isNull(request.getCookies())) {
            throw new NotDetectedAnySessionException();
        }

        Optional<Cookie> optionalCookie = Arrays.stream(request.getCookies()).filter(Objects::nonNull)
                .filter(x->x.getName().equals(COOKIE_NAME))
                .findFirst().stream().findFirst();

        if(optionalCookie.isEmpty()) {
            throw new LoginSessionNotExistException();
        }

        return optionalCookie.get();
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
