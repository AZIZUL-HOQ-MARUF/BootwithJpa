package com.aziz.dao;
 
import java.util.List;

import com.aziz.model.User;

public interface UserDao {
	public User saveUser(User user); 
	public User updateUser(User user);
	public User deleteById(Long id);
	public List<User> findAllUser();
	public User findById(Long id);

}
