package com.aziz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aziz.model.Employee;
import com.aziz.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@GetMapping(path = "/get-emp")
	public Employee getEmp() {
		return new Employee("aziz", 8401, "Java");
	}

	@GetMapping(path = "get-employee")
	public Employee getEmployee(@RequestParam(value = "ID") Long id) {

		return  empService.getEmployee(id);
	}

}
