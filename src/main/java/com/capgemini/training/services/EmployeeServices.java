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
	
	public void deleteEmployee(int id) {
	    employeeRepository.deleteById(id);
	}

	public Employee getEmployeeById(int id) {
	    return employeeRepository.findById(id).orElse(null);
	}
	
	public Employee saveEmployee(Employee employee) {
	    return employeeRepository.save(employee);
	}
	
	// Get single employee
	public Employee getSingleEmpInfo(int id) {
		
		return employeeRepository.findById(id).get();
	}
	
	// Searching
	public List<Employee> searchEmployee(String keyword) {
	    return employeeRepository.search(keyword);
	}

	public Employee updateSingleEmpInfo(int id, Employee emp) {
		
		return employeeRepository.save(emp);
	}

	public String deleteEmpInfo(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		return "Id deleted" ;
	}
}