package com.capgemini.training.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.entity.Employee;
import com.capgemini.training.services.EmployeeServices;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeServices employeeServices;

    // Get all employees
    @GetMapping("/allemp")
    public List<Employee> getAllEmployee() {
        return employeeServices.getAllEmployees();
    }
    
    @GetMapping("/getemp/{id}")
    public Employee getSingleEmployee(@PathVariable int id) {
    	return employeeServices.getSingleEmpInfo(id);
    }
    
    @PostMapping("/createemp")
    public Employee registerEmp(@RequestBody Employee emp) {
    	
    	Employee empdata = employeeServices.storeEmployee(emp);
    	
    	return empdata;
    }
    @PutMapping("/updateemp/{id}")
    public Employee updateEmp(@PathVariable int id, @RequestBody Employee emp) {
    	
    	Employee empdata = employeeServices.updateSingleEmpInfo(id,emp);
    	
    	return empdata;
    }
    @DeleteMapping("/deleteemp/{id}")
    public ResponseEntity deleteEmp(@PathVariable int id, @RequestBody Employee emp) {
    	
    	String msg = employeeServices.deleteEmpInfo(id);
    	Map<String, String> response= new HashMap<String, String>();
    	response.put("delete", msg);
    	
    	return ResponseEntity.ok(response);
    }
}