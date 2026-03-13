package com.example.service;

import java.util.List;

import com.example.exception.EmployeeNotFoundEcxeption;
import com.example.model.Employee;

public interface EmployeeService {
	
	String saveEmployee(Employee employee);

	public abstract String updateEmployee(Employee employee);

	public abstract String deleteEmployee(int empId);

	public abstract Employee getEmployee(int empId) throws EmployeeNotFoundEcxeption;

	public abstract List<Employee> getAllEmployee();

	public abstract List<Employee> getEmployeeByDesg(String empDesg);

	public abstract List<Employee> getEmployeeBetweenSalary(int firstSal, int finalSal);

}
