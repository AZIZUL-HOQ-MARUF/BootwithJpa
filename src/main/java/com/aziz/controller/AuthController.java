package com.aziz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aziz.config.AppResponse;
import com.aziz.service.AuthService;

@RestController(value="AuthController")
@RequestMapping(value="/auth")
public class AuthController {

	@Autowired
	private AuthService authService;
	@GetMapping(value="/get-login")
	public AppResponse getLoginEmp(
			@RequestParam(value = "NAME") String name, 
			@RequestParam(value = "ID") Long id) { 
		return AppResponse.build(HttpStatus.OK).message("Success").body(authService.getLoginEmp(name, id));
	}
}
