package com.revature.spring.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.ProjectDAO;
import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Project;
import com.revature.hibernate.beans.Task;

@Service
@Transactional(readOnly=true)
public class ProjectService {
	@Autowired
	ProjectDAO projectDao;
	
	@Transactional(readOnly=false)
	public Project addProject(Project project) {
		return projectDao.addProject(project);
	}
	
	public Project getProject(int projectId) {
		return projectDao.getProject(projectId);
	}
	
	public Project getProjectByTask(Task task) {
		return projectDao.getProjectByTask(task);
	}
	
	public Set<Project> getProjects() {
		return projectDao.getProjects();
	}
	
	public Set<Project> getProjectsByEmployee(Employee employee) {
		return projectDao.getProjectsByEmployee(employee);
	}

	@Transactional(readOnly=false)
	public void updateProject(Project project) {
		projectDao.updateProject(project);
	}

	@Transactional(readOnly=false)
	public void deleteProject(Project project) {
		projectDao.deleteProject(project);
	}
}
