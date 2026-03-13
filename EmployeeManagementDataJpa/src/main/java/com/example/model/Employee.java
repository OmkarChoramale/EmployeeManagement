package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Entity
//@Table(name="EmpDetails")
@Data //@getter @ setter @ RequiredArgsConstructor, @ToString, @EqualsAndHashcode
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	@Min(value=1, message="Employee id cannot be less than 1")
	private int id;
	@NotBlank(message = "Name cannot be empty or null or blank")
	@Size(min=6, max=15, message="Name length alwayes 6 to 15...")
	private String name;
	@Min(value = 25000, message="Please provide salary as labour law")
	@Max(value=700000, message="Remember more salary more tax be carefull!!!")
	private int salary;
	private String desg;
	
	
	

	
}
