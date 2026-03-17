package com.capgemini.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.training.entity.Employee;
import com.capgemini.training.services.EmployeeServices;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeServices empServices;
	
	@RequestMapping("/allemp")
	public String getAllEmp(HttpServletRequest request){
		System.out.println("**************************");
		List<Employee> listOfEmp= empServices.getAllEmployees();
		for(Employee emp: listOfEmp) {
			System.out.println("Emp : "+emp.getEmpName());
		}
		request.setAttribute("emplist", listOfEmp);
		return "home.jsp";
	}
	
}
