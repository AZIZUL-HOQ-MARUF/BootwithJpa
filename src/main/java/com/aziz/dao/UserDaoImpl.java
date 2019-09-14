package com.aziz.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aziz.controller.errorController.ResourceNotFoundException;
import com.aziz.model.User;
import com.aziz.repo.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository repo;
    private final NamedParameterJdbcTemplate db;

    @Autowired
    public UserDaoImpl(NamedParameterJdbcTemplate db) {
        this.db = db;
    }

    @Override
    public User saveUser(User user) {
        StringBuilder sql = new StringBuilder();
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("ID", user.getId());
        params.put("NAME", user.getName());
        params.put("MAIL", user.getMailAddress());

        sql.append("INSERT INTO users values (:ID,");
        sql.append(" :NAME, :MAIL )");

        db.update(sql.toString(), params);

        return user;
    }

    @Override
    public User updateUser(User user) {
        StringBuilder sql = new StringBuilder();
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("ID", user.getId());
        params.put("NAME", user.getName());
        params.put("MAIL", user.getMailAddress());
        sql.append("update users set id = :ID, username = :NAME,");
        sql.append(" Email= :MAIL where id= :ID");
        int size = db.update(sql.toString(), params);
        if (size < 1) {
            throw new ResourceNotFoundException();
        }
        return user;
    }

    @Override
    public User deleteById(Long id) {
        StringBuilder sql = new StringBuilder();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ID", id);
        sql.append("delete from users where id = :ID");
        int size = db.update(sql.toString(), params);
        if (size < 1) {
            throw new ResourceNotFoundException();
        }

        return new User();
    }

    @Override
    public List<User> findAllUser() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from users");
        return db.queryForList(sql.toString(), new HashMap());

    }

    @Override
    public User findById(Long id) {
        StringBuilder sql = new StringBuilder();
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("ID", id);
        sql.append("select * from users where id = :ID");
        try {
            return (User) db.queryForObject(sql.toString(), params, new BeanPropertyRowMapper(User.class));
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    

}
