package com.revature.spring.controllers;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Project;
import com.revature.hibernate.beans.ProjectEmployee;
import com.revature.spring.services.ProjectEmployeeService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/staffing")
public class StaffController {
	private Logger log = Logger.getLogger(StaffController.class);
	@Autowired
	ProjectEmployeeService projectEmployeeService;
	
	@PostMapping
	public ResponseEntity<ProjectEmployee> addProjectEmployee(@RequestBody ProjectEmployee projectEmployee, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Creating project employee employee " + projectEmployee.toString());
		
		return ResponseEntity.ok(projectEmployeeService.addProjectEmployee(projectEmployee));
	}
	
	@GetMapping
	public ResponseEntity<Set<ProjectEmployee>> getProjectEmployees(HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting all project employees");
		return ResponseEntity.ok(projectEmployeeService.getProjectEmployees());
	}
	
	@GetMapping(value="{projectEmployeeId}")
	public ResponseEntity<ProjectEmployee> getProjectEmployee(@PathVariable("projectEmployeeId") int projectEmployeeId, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting project employee " + projectEmployeeId);
		
		return ResponseEntity.ok(projectEmployeeService.getProjectEmployee(projectEmployeeId));
	}
	
	@PutMapping
	public ResponseEntity<Void> updateProjectEmployee(@RequestBody ProjectEmployee projectEmployee, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Updating project employee " + projectEmployee.toString());
		projectEmployeeService.updateProjectEmployee(projectEmployee);
		
		return ResponseEntity.status(200).build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteProjectEmployee(@RequestBody ProjectEmployee projectEmployee, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Updating project employee " + projectEmployee.toString());
		projectEmployeeService.deleteProjectEmployee(projectEmployee);
		
		return ResponseEntity.status(200).build();
	}
}
