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
public class GroupService {
	@Autowired
	ProjectEmployeeDAO groupDAO;
	
	@Transactional(readOnly=false)
	public ProjectEmployee addGroup(ProjectEmployee group) {
		return groupDAO.addGroup(group);
	}
	
	public ProjectEmployee getGroup(int groupId) {
		return groupDAO.getGroup(groupId);
	}
	
	public ProjectEmployee getGroupByProject(Project project) {
		return groupDAO.getGroupByProject(project);
	}
	
	public Set<ProjectEmployee> getGroupsByEmployee(Employee employee) {
		return groupDAO.getGroupsByEmployee(employee);
	}

	@Transactional(readOnly=false)
	public void updateGroup(ProjectEmployee group) {
		groupDAO.updateGroup(group);
	}

	@Transactional(readOnly=false)
	public void deleteGroup(ProjectEmployee group) {
		groupDAO.deleteGroup(group);
	}
}
