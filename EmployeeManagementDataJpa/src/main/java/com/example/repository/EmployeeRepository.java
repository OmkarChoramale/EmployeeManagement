package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("select e from Employee e where e.desg=?1")
 abstract List<Employee> getEmployeeByDesg(String empDesg);

	@Query("select e from Employee e where e.salary between ?1 and ?2")
	public abstract List<Employee> getEmployeeBetweenSalary(int firstSal, int finalSal);

}
