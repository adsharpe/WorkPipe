package com.revature.spring.services;

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
import com.revature.hibernate.beans.TaskComment;
import com.revature.spring.services.TaskCommentService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/taskcommentcontroller")
public class TaskCommentController {
	private Logger log = Logger.getLogger(TaskCommentController.class);
	
	@Autowired
	TaskCommentService taskCommentService;
	
	@PostMapping
	public ResponseEntity<TaskComment> createTaskComment(TaskComment taskComment, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Creating task " + taskComment.toString());
		
		return ResponseEntity.ok(taskCommentService.addTaskComment(taskComment));
	}
	
	@GetMapping
	public ResponseEntity<Set<TaskComment>> getTaskComments(HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting all tasks");
		
		return ResponseEntity.ok(taskCommentService.getTaskComments());
	}
	
	@GetMapping(value="{taskCommentId}")
	public ResponseEntity<TaskComment> getTaskComment(@PathVariable("taskCommentId") int taskCommentId, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting all tasks");
		
		return ResponseEntity.ok(taskCommentService.getTaskComment(taskCommentId));
	}
	
	@PutMapping
	public ResponseEntity<Void> updateTaskComment(TaskComment taskComment, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Updating task " + taskComment.toString());
		taskCommentService.updateTaskComment(taskComment);
		
		return ResponseEntity.status(200).build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteTaskComment(TaskComment taskComment, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Updating task " + taskComment.toString());
		taskCommentService.deleteTaskComment(taskComment);
		
		return ResponseEntity.status(200).build();
	}
}
