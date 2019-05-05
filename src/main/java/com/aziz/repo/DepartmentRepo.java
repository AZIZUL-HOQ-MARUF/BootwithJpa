package com.aziz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aziz.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
