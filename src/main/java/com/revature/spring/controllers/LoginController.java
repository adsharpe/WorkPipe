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

import com.revature.data.hibernate.EmployeeHibernate;
import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Login;
import com.revature.spring.services.EmployeeService;
import com.revature.spring.services.LoginService;

//moving cross origin to above the postmapping
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/login")
public class LoginController {
//	public static void main(String[] args) {
//		EmployeeService es = new EmployeeHibernate();
//	}
	private Logger log = Logger.getLogger(LoginController.class);
	@Autowired
	LoginService loginService;
	
	@Autowired
	EmployeeService employeeService;
	

	@GetMapping//(value="/login")
	public ResponseEntity<Employee> login(HttpSession session) {
		Employee employee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + employee);
		if(employee == null)
			return ResponseEntity.status(401).build();
		return ResponseEntity.ok(employee);
	}
	
<<<<<<< HEAD
	//uncommenting (value="login")
	//and changing value to path
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(path="/login")
	//change from login to getLogin because the DAO implmentation is called getLogin
	public ResponseEntity<Employee> getLogin(String username, String password, HttpSession session) {
		
		Login login = loginService.getLogin(username, password);
=======
	

	@PostMapping//(value="/login")
	public ResponseEntity<Employee> login(String user, String pass, HttpSession session) {
		log.trace("Calling LoginController PostMapping");
		log.trace("Username = " +user + " : password = " +pass);
		Login login = loginService.getLogin(user, pass);
>>>>>>> 558b785838ddb4af2f093efbb7b1667ce1fd8bd9
		
		log.trace("Login = " + login);
		
		if(login == null) {
			return ResponseEntity.status(401).build();
		}
		
		Employee employee =  (Employee) login;
		
		employee = employeeService.getEmployee(employee);
		
		log.trace("Employee = " + employee);
		
		if(employee == null) {
			return ResponseEntity.status(401).build();
		}
		
		session.setAttribute("currentUser", employee);
		log.trace("Following User logged in: " + employee);
		return ResponseEntity.ok(employee);
	}
	

	@DeleteMapping//(value="/login")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.noContent().build();
	}
}