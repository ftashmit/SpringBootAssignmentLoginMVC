package com.capgemini.training.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.training.entity.Employee;
import java.util.List;
import com.capgemini.training.dao.EmployeeRepository;

@Service
public class EmployeeServices {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
}
