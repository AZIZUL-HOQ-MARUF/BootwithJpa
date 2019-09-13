/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aziz.repo;

import com.aziz.model.User;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Maruf
 */
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select s from User s where s.name = :name and s.password = :password")
    public User getUser(@Param("name") String name,@Param("password") String password);
    
}
