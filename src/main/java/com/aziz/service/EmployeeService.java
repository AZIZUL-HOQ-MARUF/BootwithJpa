package com.aziz.service;

import com.aziz.model.Employee;

public interface EmployeeService {
	public Employee getEmployee(Long id);
	public void saveEmployee(Employee employee);
	public void deleteEmployee(Long id);

}
