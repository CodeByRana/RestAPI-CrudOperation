package com.example.demo.service;

import java.util.List;

import com.example.demo.model.EmployeeEntity;

public interface EmployeeService {
	
	public EmployeeEntity createEmployee(EmployeeEntity employee);
	
	public List<EmployeeEntity> getEmployeeEntity();
	
	public EmployeeEntity getById(int id);
	
	EmployeeEntity updateEmployeeEntity(int id, EmployeeEntity employee);
	
	void deleteById(int id);

	String matchPassword(String email, String password);
}
