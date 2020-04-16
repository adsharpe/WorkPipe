package com.revature.spring.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.ProjectEmployeeDAO;
import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.ProjectEmployee;
import com.revature.hibernate.beans.Project;

@Service
@Transactional(readOnly=true)
public class ProjectEmployeeService {
	@Autowired
	ProjectEmployeeDAO groupDAO;
	
	@Transactional(readOnly=false)
	public ProjectEmployee addProjectEmployee(ProjectEmployee projectEmployee) {
		return groupDAO.addProjectEmployee(projectEmployee);
	}
	
	public ProjectEmployee getProjectEmployee(int projectEmployeeId) {
		return groupDAO.getProjectEmployee(projectEmployeeId);
	}
	
	public Set<ProjectEmployee> getProjectEmployees() {
		return groupDAO.getProjectEmployees();
	}
	
	public Set<ProjectEmployee> getProjectEmployeesByProject(Project project) {
		return groupDAO.getProjectEmployeesByProject(project);
	}
	
	public Set<ProjectEmployee> getProjectEmployeesByEmployee(Employee employee) {
		return groupDAO.getProjectEmployeesByEmployee(employee);
	}

	@Transactional(readOnly=false)
	public void updateProjectEmployee(ProjectEmployee projectEmployee) {
		groupDAO.updateProjectEmployee(projectEmployee);
	}

	@Transactional(readOnly=false)
	public void deleteProjectEmployee(ProjectEmployee projectEmployee) {
		groupDAO.deleteProjectEmployee(projectEmployee);
	}
}
