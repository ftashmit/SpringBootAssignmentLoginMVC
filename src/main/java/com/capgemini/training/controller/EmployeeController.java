package com.capgemini.training.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/deleteemp")
	public String deleteEmployee(int id) {
	    empServices.deleteEmployee(id);
	    return "redirect:/allemp";
	}
	
	@GetMapping("/editemp")
	public String editEmployee(int id, HttpServletRequest request) {
	    Employee emp = empServices.getEmployeeById(id);
	    request.setAttribute("emp", emp);
	    return "edit-emp.jsp";
	}
	
	@PostMapping("/updateemp")
	public String updateEmployee(Employee employee) {

	    empServices.saveEmployee(employee);

	    return "redirect:/allemp";
	}
	
	@GetMapping("/view-emp")
	public String viewEmp(@RequestParam int empid, HttpServletRequest request) {
		
		System.out.println("Id : "+empid);
		
		Employee emp = empServices.getSingleEmpInfo(empid);
		
		request.setAttribute("emp", emp);
		
		return "view-emp.jsp";
	}
	
	// Searching
	@GetMapping("/search")
	public String searchEmployee(@RequestParam String keyword, HttpServletRequest request) {

	    List<Employee> list = empServices.searchEmployee(keyword);

	    request.setAttribute("emplist", list);

	    if(list.isEmpty()) {
	        request.setAttribute("message", "No employees found");
	    }

	    return "home.jsp";
	}
	
	
}