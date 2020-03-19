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
@RequestMapping(value="/tasks")
@CrossOrigin(origins="http://localhost:4200")
public class TaskController {
	private Logger log = Logger.getLogger(TaskController.class);
	
	@Autowired
	private TaskService taskService;
	
//	@Autowired
//	EmployeeService employeeService;
	
	@GetMapping //(value="/tasks")
	public ResponseEntity<Set<Task>> getTasks(){
		log.trace("retrieving all tasks: " +  taskService.getTasks());
		return ResponseEntity.ok(taskService.getTasks());
	}
	
	@PostMapping(value="/tasks")
	public ResponseEntity<Task> addTask(@RequestBody Task task){
		return ResponseEntity.status(201).body(taskService.addTask(task));
	}
	
	@GetMapping(value="{taskId}")
	public ResponseEntity<Task> getTask(@PathVariable("taskId") int taskId){
		Task task = taskService.getTask(taskId);
		if(task != null) {
			return ResponseEntity.ok(task);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(value="{taskId}")
	public ResponseEntity<Task> updateTask(@PathVariable("taskId") int taskId, @RequestBody Task task){
		taskService.updateTask(task);
		return ResponseEntity.ok(task);
	}
	
	@DeleteMapping(value="{taskId}")
	public ResponseEntity<Void> deleteTask(@PathVariable("taskId") int taskId, @RequestBody Task task){
		taskService.deleteTask(task);
		return ResponseEntity.noContent().build();
	}
	
	
}
