/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aziz.core.dao;

import com.aziz.model.User;
import com.aziz.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Maruf
 */
@Repository
public class AuthDaoImpl implements AuthDao {

    @Autowired
    UserRepository repo;

    @Override
    public User getUser(String name, String password) {
        User user = repo.getUser(name, password);
        return user;
    }

}
