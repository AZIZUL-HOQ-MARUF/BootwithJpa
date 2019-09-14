/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aziz.core;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Maruf
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Pre Haldle is Calling");
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(AuthConstrains.KEY).parseClaimsJws(request.getHeader(AuthConstrains.HEADER)).getBody();
            request.setAttribute(AuthConstrains.USER, claims.getIssuer());
            request.setAttribute(AuthConstrains.ID, claims.getId());
            request.setAttribute(AuthConstrains.MAIL, claims.getSubject());
            return true;
        } catch (Exception e) {

        }
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return false;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("Post Haldle is Calling");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception exception) throws Exception {
        System.out.println("After Haldle is Calling");
    }
}
