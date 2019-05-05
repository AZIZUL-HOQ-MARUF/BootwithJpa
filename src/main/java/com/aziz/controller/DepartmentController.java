package com.aziz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aziz.config.AppResponse;
import com.aziz.service.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
	@Autowired
	private DepartmentService service;

	@GetMapping(value="/get-all-dept")
	public AppResponse<?> getAllDept() {
		return AppResponse.build(HttpStatus.OK).body(service.getAllDepartments());
	}

}
