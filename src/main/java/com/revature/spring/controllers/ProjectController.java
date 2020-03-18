package com.revature.spring.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Project;
import com.revature.hibernate.beans.Task;
import com.revature.spring.services.ProjectService;
import com.revature.spring.services.TaskService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/project")
public class ProjectController {
	private Logger log = Logger.getLogger(ProjectController.class);
	@Autowired
	ProjectService projectService;

	@Autowired
	TaskService taskService;
	
	/********************
	 *                  *
	 * Project-specific *
	 *                  *
	 ********************/
	@PostMapping
	public ResponseEntity<Project> createProject(Project project, HttpSession session)
	{
		Employee employee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + employee);
		if(employee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Creating project " + project.getProjectname());
		
		return ResponseEntity.ok(projectService.addProject(project));
	}
	
	@GetMapping
	public ResponseEntity<Project> getProject(int projectId, HttpSession session)
	{
		Employee employee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + employee);
		if(employee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting project " + projectId);
		
		return ResponseEntity.ok(projectService.getProject(projectId));
	}
	
	@PostMapping
	public ResponseEntity<Void> updateProject(Project project, HttpSession session)
	{
		Employee employee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + employee);
		if(employee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Updating project " + project.getProjectname());
		projectService.updateProject(project);
		
		return ResponseEntity.status(200).build();
	}
	
	@PostMapping
	public ResponseEntity<Void> deleteProject(Project project, HttpSession session)
	{
		Employee employee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + employee);
		if(employee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Deleting project " + project.getProjectname());
		projectService.deleteProject(project);
		
		return ResponseEntity.status(200).build();
	}
	
	/*****************
	 *               *
	 * Task-specific *
	 *               *
	 *****************/
	@PostMapping
	public ResponseEntity<Task> createTask(Task task, HttpSession session)
	{
		Employee employee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + employee);
		if(employee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Creating task "/* + task.getTaskname()*/);
		
		return ResponseEntity.ok(taskService.addTask(task));
	}
}
