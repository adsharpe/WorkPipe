package com.revature.spring.controllers;

import javax.servlet.http.HttpSession;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Login;
import com.revature.spring.services.EmployeeService;
import com.revature.spring.services.LoginService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/login")
public class LoginController {
	private Logger log = Logger.getLogger(LoginController.class);
	@Autowired
	LoginService loginService;
	
	@Autowired
	EmployeeService employeeService;
	

	@GetMapping//(value="/login")
	public ResponseEntity<Employee> login(HttpSession session) {
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		return ResponseEntity.ok(currentEmployee);
	}
	
	

	@PostMapping//(value="/login")
	public ResponseEntity<Employee> login(String user, String pass, HttpSession session) {
		log.trace("Calling LoginController PostMapping");
		log.trace("Username = " +user + " : password = " +pass);
		Login login = loginService.getLogin(user, pass);
		
		log.trace("Login = " + login);
		
		if(login == null) {
			return ResponseEntity.status(401).build();
		}
		
		Employee currentEmployee =  (Employee) login;
		
		currentEmployee = employeeService.getEmployee(currentEmployee);
		
		log.trace("Employee = " + currentEmployee);
		
		if(currentEmployee == null) {
			return ResponseEntity.status(401).build();
		}
		
		session.setAttribute("currentUser", currentEmployee);
		log.trace("Following User logged in: " + currentEmployee);
		return ResponseEntity.ok(currentEmployee);
	}
	

	@DeleteMapping//(value="/login")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.noContent().build();
	}
}