package com.aziz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aziz.model.Employee;

@RestController
public class EmployeeController {

	@GetMapping(path = "/get-emp")
	public Employee getEmp() {
		return new Employee("aziz", 8401, "Java");
	}

}
