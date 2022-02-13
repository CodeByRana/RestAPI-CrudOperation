package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.respository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepo;

	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public EmployeeEntity createEmployee(EmployeeEntity employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public List<EmployeeEntity> getEmployeeEntity() {
		return employeeRepo.findAll();
	}

	@Override
	public EmployeeEntity getById(int id) {
		return employeeRepo.findById(id).get();
	}

	@Override
	public EmployeeEntity updateEmployeeEntity(int id, EmployeeEntity employee) {
		EmployeeEntity newEmployeeEntity = employeeRepo.findById(id).get();
		newEmployeeEntity.setFirstName(employee.getFirstName());
		newEmployeeEntity.setLastName(employee.getLastName());
		newEmployeeEntity.setEmail(employee.getEmail());
		return employeeRepo.save(newEmployeeEntity);
	}

	@Override
	public void deleteById(int id) {
		
		employeeRepo.deleteById(id);
	}
	
	public String matchPassword(String email, String password) {
		
		List<EmployeeEntity> employee = employeeRepo.findAll();
		for(EmployeeEntity obj : employee) {
			if(obj.getEmail().equals(email) && obj.getPassword().equals(password)) {
				return "Logged in ";
			}
		}
		return "Invalid username and password !";
	}
	
}
