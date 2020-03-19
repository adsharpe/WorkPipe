package com.revature.spring.controllers;

import java.util.Set;

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
import com.revature.hibernate.beans.Status;
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
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Creating project " + project.getProjectname());
		
		return ResponseEntity.ok(projectService.addProject(project));
	}
	
	@GetMapping
	public ResponseEntity<Project> getProject(int projectId, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting project " + projectId);
		
		return ResponseEntity.ok(projectService.getProject(projectId));
	}
	
	@GetMapping
	public ResponseEntity<Project> getProjectByTask(Task task, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting project by task " + task.toString());
		
		return ResponseEntity.ok(projectService.getProjectByTask(task));
	}
	
	@GetMapping
	public ResponseEntity<Set<Project>> getProjects(HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting all projects");
		
		return ResponseEntity.ok(projectService.getProjects());
	}
	
	@GetMapping
	public ResponseEntity<Set<Project>> getProjectsByEmployee(Employee employee, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting project by employee " + employee.toString());
		
		return ResponseEntity.ok(projectService.getProjectsByEmployee(employee));
	}
	
	@PostMapping
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
	
	@PostMapping
	public ResponseEntity<Void> deleteProject(Project project, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
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
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Creating task " + task.getDescription());
		
		return ResponseEntity.ok(taskService.addTask(task));
	}
	
	@GetMapping
	public ResponseEntity<Task> getTask(int taskId, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting task " + taskId);
		
		return ResponseEntity.ok(taskService.getTask(taskId));
	}
	
	@GetMapping
	public ResponseEntity<Set<Task>> getTasksByProject(Project project, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting tasks for project " + project.getProjectname());
		
		return ResponseEntity.ok(taskService.getTasksByProject(project));
	}
	
	@GetMapping
	public ResponseEntity<Set<Task>> getTasks(HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting all tasks");
		
		return ResponseEntity.ok(taskService.getTasks());
	}
	
	@GetMapping
	public ResponseEntity<Set<Task>> getTasksByStatus(Status status, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting tasks by status " + status.toString());
		
		return ResponseEntity.ok(taskService.getTasksByStatus(status));
	}
	
	@GetMapping
	public ResponseEntity<Set<Task>> getTasksByEmployee(Employee employee, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting tasks by status " + employee.toString());
		
		return ResponseEntity.ok(taskService.getTasksByEmployee(employee));
	}
	
	@PostMapping
	public ResponseEntity<Void> updateTask(Task task, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Updating task " + task.getDescription());
		taskService.updateTask(task);
		
		return ResponseEntity.status(200).build();
	}
	
	@PostMapping
	public ResponseEntity<Void> deleteTask(Task task, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Deleting task " + task.getDescription());
		taskService.deleteTask(task);
		
		return ResponseEntity.status(200).build();
	}
}
