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

import com.revature.hibernate.beans.Task;
import com.revature.spring.services.TaskService;
import com.revature.hibernate.beans.Employee;
import com.revature.spring.services.EmployeeService;

@RestController
//@RequestMapping(value="/tasks")
@CrossOrigin(origins="http://localhost:4200")
public class TaskController {
	private Logger log = Logger.getLogger(TaskController.class);
	
	@Autowired
	private TaskService taskService;
	
//	@Autowired
//	EmployeeService employeeService;
	
	@GetMapping(value="/tasks")
	public ResponseEntity<Set<Task>> getTasks(){
		log.trace("retrieving all tasks: " +  taskService.getTasks());
		return ResponseEntity.ok(taskService.getTasks());
	}
	
	@PostMapping(value="/tasks")
	public ResponseEntity<Task> addTask(@RequestBody Task task, HttpSession session){
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null) {
			return ResponseEntity.status(401).build();
		}
		
		log.trace("creating new task here ..." + task);
		return ResponseEntity.status(201).body(taskService.addTask(task));
	}
	
	@PutMapping(value="/tasks")
	public ResponseEntity<Task> updateTask(@RequestBody Task task, HttpSession session){
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null) {
			return ResponseEntity.status(401).build();
		}
		log.trace("Updating task " + task.toString());
		taskService.updateTask(task);
		
		return ResponseEntity.status(200).build();
	}
	
//	@PutMapping
//	public ResponseEntity<Task> updateTask(@RequestBody Task task, HttpSession session){
//		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
//		if(currentEmployee == null) {
//			return ResponseEntity.status(401).build();
//		}
//		taskService.updateTask(task);
//		return ResponseEntity.ok(task);
//	}
	
	@GetMapping(value="/tasks/{taskId}")
	public ResponseEntity<Task> getTask(@PathVariable("taskId") int taskId){
		log.trace("task by employee");
		Task task = taskService.getTask(taskId);
		if(task != null) {
			return ResponseEntity.ok(task);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	

	

	
	@DeleteMapping(value="{taskId}")
	public ResponseEntity<Void> deleteTask(@PathVariable("taskId") int taskId, @RequestBody Task task){
		taskService.deleteTask(task);
		return ResponseEntity.noContent().build();
	}
	
	
}
