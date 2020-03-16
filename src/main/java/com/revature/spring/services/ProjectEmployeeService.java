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
	ProjectEmployeeDAO ProjectEmployeeDAO;
	
	@Transactional(readOnly=false)
	public ProjectEmployee addProjectEmployee(ProjectEmployee group) {
		return ProjectEmployeeDAO.addProjectEmployee(group);
	}
	
	public ProjectEmployee getProjectEmployee(int groupId) {
		return ProjectEmployeeDAO.getProjectEmployee(groupId);
	}
	
	public ProjectEmployee getProjectEmployeeByProject(Project project) {
		return ProjectEmployeeDAO.getProjectEmployeeByProject(project);
	}
	
	public Set<ProjectEmployee> getProjectEmployeeByEmployee(Employee employee) {
		return ProjectEmployeeDAO.getProjectEmployeeByEmployee(employee);
	}

	@Transactional(readOnly=false)
	public void updateProjectEmployee(ProjectEmployee group) {
		ProjectEmployeeDAO.updateProjectEmployee(group);
	}

	@Transactional(readOnly=false)
	public void deleteProjectEmployee(ProjectEmployee group) {
		ProjectEmployeeDAO.deleteProjectEmployee(group);
	}
}
