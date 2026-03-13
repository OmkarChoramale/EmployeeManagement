package com.example.controller;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.EmployeeNotFoundEcxeption;
import com.example.model.Employee;
import com.example.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {// http://localhost:1277/employees

	EmployeeService service;
	
	
 
	@GetMapping("/message") // http://localhost:1277/employees/message
	public String getMessage() {
		return "Leave us we are getting sleepy!!!!!!";
	}
 
	@PostMapping("/save") // http://localhost:1277/employees/save
	public String createEmployee(@Valid @RequestBody Employee employee) {//converting json to object
		return service.saveEmployee(employee);
	}
 
	@PutMapping("/update") // http://localhost:1277/employees/update
	public String updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}
 
	@DeleteMapping("/delete/{empId}") // http://localhost:1277/employees/delete
	public String deleteEmployee(@PathVariable int empId) {
		return service.deleteEmployee(empId);
	}
 
 
	@GetMapping("fetch/{empId}") // http://localhost:1277/employees/fetch/123
	public Employee getEmployee(@PathVariable int empId) throws EmployeeNotFoundEcxeption {
		return service.getEmployee(empId);
	}
 
	@GetMapping("fetchAll") // http://localhost:1277/employees/fetchAll
	public List<Employee> getAllEmployee() {
		return service.getAllEmployee();
	}
 
	@GetMapping("fetchAllByDesg/{empDesg}") // http://localhost:1277/employees/fetchAllByDesg
	public List<Employee> getAllEmployeeByDesg(@PathVariable String empDesg) {
		return service.getEmployeeByDesg(empDesg);
	}
 
	@GetMapping("fetchAllBetween") // http://localhost:1277/employees/fetchAllBetween
	public List<Employee> getAllEmployeesBetween(@RequestParam("sal1") int intitialSal,
			@RequestParam("sal2") int finalSal) {
		return service.getEmployeeBetweenSalary(intitialSal, finalSal);
	}
}