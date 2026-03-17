package com.capgemini.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.training.dao.EmployeeRepository;
import com.capgemini.training.entity.Employee;

@Service
public class EmployeeServices {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		
		return employeeRepository.findAll();
	}
	
	public Employee storeEmployee(Employee emp) {
		
		return employeeRepository.save(emp);
	}
}