package com.capgemini.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.training.UemSpringBootMvcApplication;
import com.capgemini.training.entity.UserEntity;
import com.capgemini.training.services.LoginServices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
	
	private final UemSpringBootMvcApplication uemSpringBootMvcApplication = new UemSpringBootMvcApplication();
	
	@Autowired
	LoginServices loginServices;
	
	
	
	@GetMapping("/")
	public String loginPage() {
		return "login.jsp";
	}
	
	@PostMapping("/login")
	public String validate(String user, String password, HttpServletRequest request, HttpServletResponse response) {
		String page = null;
		System.out.println(user);
		System.out.println(password);
		
		boolean flag = loginServices.validateUser(user, password);
		if(flag) {
			try {
				request.getRequestDispatcher("/allemp").forward(request, response);
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}else {
			page = "login.jsp";
		}
		return page;
	}
	
	@GetMapping("/sign-up")
	public String signUp() {
		return "register.html";
	}
	
	@PostMapping("/register")
	public String register(HttpServletRequest request){

	    String name = request.getParameter("name");
	    String user = request.getParameter("user");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");

	    System.out.println("Name : " + name);
	    System.out.println("User : " + user);
	    System.out.println("Email : " + email);
	    System.out.println("Password : " + password);
	    
	    UserEntity userEntity = new UserEntity();

	    userEntity.setName(name);
	    userEntity.setUser(user);
	    userEntity.setEmail(email);
	    userEntity.setPassword(password);

	    loginServices.registerUser(userEntity);

	    return "home.jsp";
	}
}