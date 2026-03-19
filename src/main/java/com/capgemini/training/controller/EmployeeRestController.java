package com.capgemini.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}