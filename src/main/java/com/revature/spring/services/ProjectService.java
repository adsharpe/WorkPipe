package com.revature.spring.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.ProjectDAO;
import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Project;

@Service
@Transactional(readOnly=true)
public class ProjectService {
	@Autowired
	ProjectDAO projectDao;
	
	
}
