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
import com.revature.hibernate.beans.ProjectComment;
import com.revature.spring.services.ProjectCommentService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/messages")//ProjectComments
public class ProjectCommentController {
	private Logger log = Logger.getLogger(ProjectCommentController.class);
	
	@Autowired
	ProjectCommentService projectCommentService;
	
	@PostMapping
	public ResponseEntity<ProjectComment> createProjectComment(ProjectComment projectComment, HttpSession session)
	{
		log.trace("submitting a comment");
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Creating project comment " + projectComment.toString());
		
		return ResponseEntity.ok(projectCommentService.addProjectComment(projectComment));
	}
	
	@GetMapping
	public ResponseEntity<Set<ProjectComment>> getProjectComments(HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting all project comments");
		log.trace("All comments: " + projectCommentService.getProjectComments());
		return ResponseEntity.ok(projectCommentService.getProjectComments());
	}
	
	@GetMapping(value="{projectCommentId}")
	public ResponseEntity<ProjectComment> getProjectComment(@PathVariable("projectCommentId") int projectCommentId, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting project comment by id" + projectCommentId);
		
		return ResponseEntity.ok(projectCommentService.getProjectComment(projectCommentId));
	}
	
	@PutMapping
	public ResponseEntity<Void> updateProjectComment(ProjectComment projectComment, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Updating project comment " + projectComment.toString());
		projectCommentService.updateProjectComment(projectComment);
		
		return ResponseEntity.status(200).build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteProjectComment(ProjectComment projectComment, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Deleting project comment " + projectComment.toString());
		projectCommentService.deleteProjectComment(projectComment);
		
		return ResponseEntity.status(200).build();
	}
}
