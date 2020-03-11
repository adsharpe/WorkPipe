package com.revature.spring.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.TaskDAO;
import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Project;
import com.revature.hibernate.beans.Status;
import com.revature.hibernate.beans.Task;

@Service
@Transactional(readOnly=true)
public class TaskService {
	@Autowired
	TaskDAO taskDao;
	
	@Transactional(readOnly=false)
	public int addTask(Task task) {
		return taskDao.addTask(task);
	}
	
	public Task getTask(int taskId) {
		return taskDao.getTask(taskId);
	}
	
	public Set<Task> getTasksByProject(Project project) {
		return taskDao.getTasksByProject(project);
	}
	
	public Set<Task> getTasks() {
		return taskDao.getTasks();
	}
	
	public Set<Task> getTasksByStatus(Status status) {
		return taskDao.getTasksByStatus(status);
	}
	
	public Set<Task> getTasksByEmployee(Employee employee) {
		return taskDao.getTasksByEmployee(employee);
	}

	@Transactional(readOnly=false)
	public void updateTask(Task task) {
		taskDao.updateTask(task);
	}

	@Transactional(readOnly=false)
	public void deleteTask(Task task) {
		taskDao.deleteTask(task);
	}
}
