package com.revature.data;

import java.util.Set;

import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Project;
import com.revature.hibernate.beans.Status;
import com.revature.hibernate.beans.Task;

public interface TaskDAO {
		// create
		public Task addTask(Task task);
		
		// read
		public Task getTask(int taskId);
		public Set<Task> getTasksByProject(Project project);
		public Set<Task> getTasks();
		public Set<Task> getTasksByStatus(Status status);
		public Set<Task> getTasksByEmployee(Employee employee);
		
		// update
		public void updateTask(Task task);
		
		// delete
		public void deleteTask(Task task);
}
