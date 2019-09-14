/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aziz.core.dao;

import com.aziz.model.User;

/**
 *
 * @author Maruf
 */

public interface AuthDao {
     public User getUser(String name, String password);
}
