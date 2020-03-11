package com.revature.spring.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.GroupDAO;
import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Group;
import com.revature.hibernate.beans.Project;

@Service
@Transactional(readOnly=true)
public class GroupService {
	@Autowired
	GroupDAO groupDAO;
	
	@Transactional(readOnly=false)
	public int addGroup(Group group) {
		return groupDAO.addGroup(group);
	}
	
	public Group getTaskComment(int taskId) {
		return groupDAO.getTaskComment(taskId);
	}
	
	public Group getGroupByProject(Project project) {
		return groupDAO.getGroupByProject(project);
	}
	
	public Set<Group> getGroupsByEmployee(Employee employee) {
		return groupDAO.getGroupsByEmployee(employee);
	}

	@Transactional(readOnly=false)
	public void updateGroup(Group group) {
		groupDAO.updateGroup(group);
	}

	@Transactional(readOnly=false)
	public void deleteGroup(Group group) {
		groupDAO.deleteGroup(group);
	}
}
