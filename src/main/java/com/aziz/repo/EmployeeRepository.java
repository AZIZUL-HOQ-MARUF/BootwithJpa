package com.aziz.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aziz.model.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query("select e from Employee e where e.name = :name and e.id = :id")
	public Employee getEmpById(@Param("id") Long id, @Param("name") String name);

}
