package com.aziz.service;

import java.util.List;

import com.aziz.model.Employee;

public interface EmployeeService {
	public Employee getEmployee(Long id);
	public void saveEmployee(Employee employee);
	public Employee deleteEmployee(Long id);
	public List<Employee> getAllEmployee(); 
	public Employee getLoginEmp(String name, Long id);

}
