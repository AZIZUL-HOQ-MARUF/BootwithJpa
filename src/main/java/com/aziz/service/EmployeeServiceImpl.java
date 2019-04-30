package com.aziz.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aziz.model.Employee;
import com.aziz.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeRepository repo;
	void setRepo(EmployeeRepository repo) {
		this.repo = repo;
	}

	@Override
	public Employee getEmployee(Long id) {
		Optional<Employee> emp = repo.findById(id);
		return emp.isPresent() == false ? new Employee() : emp.get();
	}

}
