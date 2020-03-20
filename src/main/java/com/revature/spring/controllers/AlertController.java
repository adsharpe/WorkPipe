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

import com.revature.hibernate.beans.Communique;
import com.revature.hibernate.beans.CommuniqueType;
import com.revature.hibernate.beans.Employee;
import com.revature.spring.services.CommuniqueService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/alert")
public class AlertController {
	private Logger log = Logger.getLogger(AlertController.class);
	
	@Autowired
	CommuniqueService communiqueService;
	
	@PostMapping
	public ResponseEntity<Communique> createAlert(Communique communique, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Creating communique " + communique.toString());
		
		return ResponseEntity.ok(communiqueService.addCommunique(communique));
	}
	
	@GetMapping
	public ResponseEntity<Set<Communique>> getAlerts(HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting all alerts");
		
		CommuniqueType communiqueType = new CommuniqueType();
		communiqueType.setType("TYPE_ALERT");
		
		return ResponseEntity.ok(communiqueService.getCommuniqueByCommuniqueType(communiqueType));
	}
	
	@GetMapping(value="{alertId}")
	public ResponseEntity<Communique> getAlert(@PathVariable("alertId") int alertId, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Getting alert " + alertId);
		
		return ResponseEntity.ok(communiqueService.getCommunique(alertId));
	}
	
	@PutMapping
	public ResponseEntity<Void> updateAlert(Communique communique, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Updating alert " + communique.toString());
		communiqueService.updateCommunique(communique);
		
		return ResponseEntity.status(200).build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteAlert(Communique communique, HttpSession session)
	{
		Employee currentEmployee = (Employee)session.getAttribute("currentUser");
		log.trace("Following User logged in: " + currentEmployee);
		if(currentEmployee == null)
			return ResponseEntity.status(401).build();
		
		log.trace("Deleting alert " + communique.toString());
		communiqueService.deleteCommunique(communique);
		
		return ResponseEntity.status(200).build();
	}
}
