package com.aziz.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aziz.controller.errorController.ResourceNotFoundException;
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

	@Override
	public void saveEmployee(Employee employee) {
		this.repo.save(employee);

	}

	@Override
	public Employee deleteEmployee(Long id) {
		Optional<Employee> e = null;
		if(this.repo.existsById(id)) {
			e =  repo.findById(id);
			this.repo.deleteById(id);
		} 
		else {
			throw new ResourceNotFoundException("Employe ID : "+id+" not Found");
		}
		return e.get();
	}

	@Override
	public List<Employee> getAllEmployee() { 
		return this.repo.findAll();
	}

	@Override
	public Employee getLoginEmp(String name, Long id) {
		return this.repo.getEmpById(id, name);
	}
 

}
