
package com.revature.spring.controllers;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hibernate.beans.Employee;
import com.revature.spring.services.EmployeeService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/employee")
public class EmployeeController {
	private Logger log = Logger.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<Set<Employee>> getEmployees(HttpSession session) {
		System.out.println(session.isNew());
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting all employees");
		
		return ResponseEntity.ok(employeeService.getEmployees());
	}
}
