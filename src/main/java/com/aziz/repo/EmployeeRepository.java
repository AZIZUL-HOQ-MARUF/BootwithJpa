package com.aziz.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aziz.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
