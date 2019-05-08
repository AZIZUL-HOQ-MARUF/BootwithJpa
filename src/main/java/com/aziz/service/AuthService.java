package com.aziz.service;

import com.aziz.model.Employee;

public interface AuthService {
	public Employee getLoginEmp(String name, Long id);
}
