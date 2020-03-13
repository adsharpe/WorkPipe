package com.revature.data;

import java.util.Set;

import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Task;
import com.revature.hibernate.beans.TaskComment;

public interface TaskCommentDAO {
		// create
		public TaskComment addTaskComment(TaskComment tc);
		// read
		public TaskComment getTaskComment(int i);
		public Set<TaskComment> getTaskComments();
		public Set<TaskComment> getTaskCommentsByTask(Task t);
		public Set<TaskComment> getTaskCommentsByEmployee(Employee emp);
		// update
		public void updateTaskComment(TaskComment tc);
		// delete
		public void deleteTaskComment(TaskComment tc);
}
