/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aziz.core.controller;

import com.aziz.config.AppResponse;
import com.aziz.core.AuthConstrains;
import com.aziz.core.dao.AuthDao;
import com.aziz.dao.UserDao;
import com.aziz.model.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Maruf
 */
@RestController
@RequestMapping("/core/auth")
public class AuthController {

    @Autowired
    AuthDao authDao;

    @PostMapping(path = "/login")
    AppResponse login(
            @RequestParam(value = "USER") String userName,
             @RequestParam(value = "PASS") String pass) {
        System.out.println(userName + "fgdgdfgfdg");
        User user = authDao.getUser(userName, pass);
        if (user != null) {
            user.setPassword("");
            JwtBuilder token = Jwts.builder()
                    .setIssuer(user.getName())
                    .setId(user.getId().toString())
                    .setIssuedAt(new Date())
                    .setSubject(user.getMailAddress())
                    .signWith(SignatureAlgorithm.HS256, AuthConstrains.KEY);
            Map tokenMap = new HashMap();
            tokenMap.put("TOKEN", token.compact());

            return AppResponse.build(HttpStatus.OK).body(tokenMap).message("Token Generetion Success");
        } else {
            return AppResponse.build(HttpStatus.UNAUTHORIZED).message("Login Failed");
        }

    }

}
