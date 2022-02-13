package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	/***Insert Data in a Database ***/
	@PostMapping("/saveEmployee")
	public ResponseEntity<EmployeeEntity> saveEmployeeEntity(@RequestBody EmployeeEntity employee){
		return new ResponseEntity<EmployeeEntity>(employeeService.createEmployee(employee), HttpStatus.CREATED);
	}
	
	/***Get all data from database***/
	@GetMapping("/getEmployee")
	public List<EmployeeEntity> getEmployeeEntity(){
		return employeeService.getEmployeeEntity();
	}
	
	/***Get a data from database by particular id through***/
	@GetMapping("{id}")
	public EmployeeEntity getById(@PathVariable("id")int id) {
		return employeeService.getById(id);
	}
	
	/***Update a data for particular id value***/
	@PutMapping("{id}")
	public EmployeeEntity updateEmployeeEntity(@PathVariable("id") int id, @RequestBody EmployeeEntity employee) {
		return employeeService.updateEmployeeEntity(id, employee);
	}
	
	/***Delete a data by id through***/
	@DeleteMapping("{id}")
	public String deleteById(@PathVariable("id") int id) {
		employeeService.deleteById(id);
		return "Deleted Id : " +id;
	}
	
	/***Login Page***/
	@PostMapping("/login/{email}/{password}")
	public String loginUser(@PathVariable String email,@PathVariable String password) {
		return employeeService.matchPassword(email,password);
	}
	
	/***Forgot Password*/
	
	
}
