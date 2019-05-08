package com.aziz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aziz.controller.errorController.ResourceNotFoundException;
import com.aziz.model.Employee;
import com.aziz.repo.EmployeeRepository;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	public EmployeeRepository repo;

	@Override
	public Employee getLoginEmp(String name, Long id) {
		Employee e = repo.getEmpById(id, name);
		if (e == null) {
			throw new ResourceNotFoundException();
		}
		return e;
	}

}
