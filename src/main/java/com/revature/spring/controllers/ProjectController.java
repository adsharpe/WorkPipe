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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Project;
import com.revature.spring.services.ProjectService;
import com.revature.spring.services.TaskService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/projects")
public class ProjectController {
	private Logger log = Logger.getLogger(ProjectController.class);
	@Autowired
	ProjectService projectService;
	
	@PostMapping
	public ResponseEntity<Project> createProject(Project project, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Creating project " + project.getProjectname());
		
		return ResponseEntity.ok(projectService.addProject(project));
	}
	
	@GetMapping
	public ResponseEntity<Set<Project>> getProjects(HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Getting all projects for: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting all projects");
		log.trace("All projects: " + projectService.getProjects());
		return ResponseEntity.ok(projectService.getProjects());
	}
	
	@GetMapping(value="{projectId}")
	public ResponseEntity<Project> getProject(@PathVariable("projectId") int projectId, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting all projects");
		
		return ResponseEntity.ok(projectService.getProject(projectId));
	}
	
	@PutMapping
	public ResponseEntity<Void> updateProject(Project project, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Updating project " + project.getProjectname());
		projectService.updateProject(project);
		
		return ResponseEntity.status(200).build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteProject(Project project, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Updating project " + project.getProjectname());
		projectService.deleteProject(project);
		
		return ResponseEntity.status(200).build();
	}
}
