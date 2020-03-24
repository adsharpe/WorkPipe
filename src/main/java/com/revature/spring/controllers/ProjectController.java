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
import com.revature.spring.services.ProjectService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/projects")
public class ProjectController {
	private Logger log = Logger.getLogger(ProjectController.class);
	@Autowired
	ProjectService projectService;
	
	@PostMapping
<<<<<<< HEAD
	public ResponseEntity<Project> createProject( Project project, HttpSession session)
=======
	public ResponseEntity<Project> createProject(@RequestBody Project project, HttpSession session)
>>>>>>> e4886ea0866607d94b7393fa6a753e83e54a45f1
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null) {
			return ResponseEntity.status(401).build();
		
		log.trace("Creating project " + project);
		
		//return ResponseEntity.ok(projectService.addProject(project));
		return ResponseEntity.status(201).body(projectService.addProject(project));
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
		
		log.trace("Getting project " + projectId);
		
		return ResponseEntity.ok(projectService.getProject(projectId));
	}
	
	@PutMapping
<<<<<<< HEAD
	public ResponseEntity<Void> updateProject( Project project, HttpSession session)
=======
	public ResponseEntity<Void> updateProject(Project project, HttpSession session)
>>>>>>> e4886ea0866607d94b7393fa6a753e83e54a45f1
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Updating project " + project.toString());
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
		
		log.trace("Updating project " + project.toString());
		projectService.deleteProject(project);
		
		return ResponseEntity.status(200).build();
	}
}
