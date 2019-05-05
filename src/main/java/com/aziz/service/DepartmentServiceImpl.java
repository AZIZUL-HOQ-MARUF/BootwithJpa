package com.aziz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aziz.model.Department;
import com.aziz.repo.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepo repo;
	@Override
	public List<Department> getAllDepartments() { 
		return this.repo.findAll();
	}

}
