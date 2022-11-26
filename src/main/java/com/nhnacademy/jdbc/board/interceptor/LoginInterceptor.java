package com.nhnacademy.jdbc.board.interceptor;

import com.nhnacademy.jdbc.board.CookieManager;
import com.nhnacademy.jdbc.board.exception.LoginSessionNotExistException;
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
                Cookie cookie = CookieManager.getCookie(request);
                log.info("Login Session Exist : " + cookie.getValue());
            }catch (Exception e){
                response.sendRedirect("/login");
            }
            return true;
        }

}
