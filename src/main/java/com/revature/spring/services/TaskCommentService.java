package com.revature.spring.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.TaskCommentDAO;
import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Task;
import com.revature.hibernate.beans.TaskComment;

@Service
@Transactional(readOnly=true)
public class TaskCommentService {
	@Autowired
	TaskCommentDAO taskCommentDao;
	
	@Transactional(readOnly=false)
	public TaskComment addTaskComment(TaskComment taskComment) {
		return taskCommentDao.addTaskComment(taskComment);
	}
	
	public TaskComment getTaskComment(int taskCommentId) {
		return taskCommentDao.getTaskComment(taskCommentId);
	}
	
	public Set<TaskComment> getTaskComments() {
		return taskCommentDao.getTaskComments();
	}
	
	public Set<TaskComment> getTaskCommentsByTask(Task task) {
		return taskCommentDao.getTaskCommentsByTask(task);
	}
	
	public Set<TaskComment> getTaskCommentsByEmployee(Employee employee) {
		return taskCommentDao.getTaskCommentsByEmployee(employee);
	}

	@Transactional(readOnly=false)
	public void updateTaskComment(TaskComment taskComment) {
		taskCommentDao.updateTaskComment(taskComment);
	}

	@Transactional(readOnly=false)
	public void deleteTaskComment(TaskComment taskComment) {
		taskCommentDao.deleteTaskComment(taskComment);
	}
}
