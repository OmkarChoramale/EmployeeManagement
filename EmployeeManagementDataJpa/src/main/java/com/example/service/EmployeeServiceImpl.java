package com.example.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.example.exception.EmployeeNotFoundEcxeption;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

   
	
	EmployeeRepository repository;
	
	

    
	
	public EmployeeServiceImpl(EmployeeRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public String saveEmployee(Employee employee) {
		repository.save(employee);
		return "Employee saved successFully...";
	}

	@Override
	public String updateEmployee(Employee employee) {
		
		repository.save(employee);
		return "Employee updated successFully...";
	}

	@Override
	public String deleteEmployee(int empId) {
		
		repository.deleteById(empId);
		return "Employee deleted successFully...";
	}

	@Override
	public Employee getEmployee(int empId) throws EmployeeNotFoundEcxeption {
		
		Optional<Employee> optional=repository.findById(empId);
		 
		
		if(optional.isEmpty()) {
			throw new EmployeeNotFoundEcxeption("Employee not found..");
		}else {
			return optional.get();
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		
	
		return repository.findAll();
	}

	@Override
	public List<Employee> getEmployeeByDesg(String empDesg) {
		
		return repository.getEmployeeByDesg(empDesg);
	}

	@Override
	public List<Employee> getEmployeeBetweenSalary(int firstSal, int finalSal) {
		
	return repository.getEmployeeBetweenSalary(firstSal,finalSal);
	}

	
}
