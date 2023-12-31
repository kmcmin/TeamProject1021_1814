package com.example.config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private String errorPage;

    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException, ServletException {

        String deniedUrl = errorPage + "?exception=로그인이 필요합니다.";
        httpServletResponse.sendRedirect(deniedUrl);
    }

    public void setErrorPage(String errorPage){
        this.errorPage = errorPage;
    }
}
