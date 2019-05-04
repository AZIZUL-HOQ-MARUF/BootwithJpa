package com.aziz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aziz.config.AppResponse;
import com.aziz.dao.UserDao;
import com.aziz.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao dao;

	@PostMapping("/save-user")
	public AppResponse<?> save(@RequestBody User user) {
		return AppResponse.build(HttpStatus.OK).body(dao.saveUser(user));
	}

	@PostMapping(value = "/update-user")
	public AppResponse<?> update(@RequestBody User user) {
		return AppResponse.build(HttpStatus.OK).body(dao.updateUser(user));
	}

	@PostMapping(value="/delete-user")
	AppResponse<?> delete(@RequestParam(value = "ID") long id) {

		return AppResponse.build(HttpStatus.OK).message("Deleted successfully").body(dao.deleteById(id));
	}
	@GetMapping(value= "/get-all-user")
	AppResponse<?> findAllUser(){
		return AppResponse.build(HttpStatus.OK).body(dao.findAllUser());
	}
	@GetMapping(value="/get-user/{id}")
	AppResponse<?> findUser(@PathVariable(value="id") Long id){
		return AppResponse.build(HttpStatus.OK).body(dao.findById(id));
	}

}
