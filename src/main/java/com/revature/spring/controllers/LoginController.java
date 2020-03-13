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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Login;
import com.revature.spring.services.EmployeeService;
import com.revature.spring.services.LoginService;

@RestController
@RequestMapping(value="/login")
@CrossOrigin(origins="http://localhost:4200")
public class LoginController {
	private Logger log = Logger.getLogger(LoginController.class);
	@Autowired
	LoginService loginService;
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<Employee> login(HttpSession session) {
		Employee employee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + employee);
		if(employee == null)
			return ResponseEntity.status(401).build();
		return ResponseEntity.ok(employee);
	}
	
	
	@PostMapping
	public ResponseEntity<Employee> login(@RequestParam("user") String username, 
			@RequestParam("pass") String password, HttpSession session) {
		
		Login login = loginService.getLogin(username, password);
		
		
		if(login == null) {
			return ResponseEntity.status(401).build();
		}
		
		Employee employee = new Employee(login.getId());
		
		employee = employeeService.getEmployee(employee);
		
		if(employee == null) {
			return ResponseEntity.status(401).build();
		}
		
		session.setAttribute("currentUser", employee);
		log.trace("Following User logged in: " + employee);
		return ResponseEntity.ok(employee);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.noContent().build();
	}
}
