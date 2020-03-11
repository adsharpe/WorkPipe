package com.revature.data;

import java.util.Set;

import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Project;
import com.revature.hibernate.beans.Status;
import com.revature.hibernate.beans.Task;

public interface TaskDAO {
		// create
		public int addTask(Task t);
		// read
		public Task getTask(int i);
		public Set<Task> getTasksByProject(Project p);
		public Set<Task> getTasks();
		public Set<Task> getTasksByStatus(Status s);
		public Set<Task> getTasksByEmployee(Employee emp);
		// update
		public void updateTask(Task t);
		// delete
		public void deleteTask(Task t);
}
