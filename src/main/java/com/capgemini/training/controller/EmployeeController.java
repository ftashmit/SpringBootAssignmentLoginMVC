package com.capgemini.training.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.training.entity.Employee;
import com.capgemini.training.services.EmployeeServices;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeServices empServices;
	
	@RequestMapping("/allemp")
	public String getAllEmployees(HttpServletRequest request) {
		System.out.println("***************************");
		List<Employee> listOfEmployees = empServices.getAllEmployees();
		for(Employee emp: listOfEmployees) {
			System.out.println(" Emp : "+ emp.getEmpName());
		}
		request.setAttribute("emplist", listOfEmployees);
		
		return "home.jsp";
		
	}
	
	@GetMapping("/addemp")
	public String createEmp() {
		
		return "register-emp.jsp";
	}
	
	@PostMapping("/addemp")
	public String registerEmp(HttpServletRequest request) {
		
		String empId = request.getParameter("empId");
		String empName = request.getParameter("empName");
		String empEmail = request.getParameter("empEmail");
		String contactNo = request.getParameter("empContactNo");
		String empCity = request.getParameter("empCity");
		
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setEmpName(empName);
		employee.setEmpEmail(empEmail);
		employee.setEmpCity(empCity);
		employee.setEmpContactNo(Long.parseLong(contactNo));
		
		empServices.storeEmployee(employee);
		
		return "redirect:/allemp";
	}
	
}