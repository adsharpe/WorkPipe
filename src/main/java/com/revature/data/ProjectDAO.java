package com.revature.data;

import java.util.Set;

import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Project;


public interface ProjectDAO {

		// create
		public int addProject(Project b);
		// read
		public Project getBook(int i);
		public Project getBookByIsbn(String isbn);
		public Set<Project> getProjects();
		public Set<Project> getProjectsByEmployee(Employee emp);
		// update
		public void updateProject(Project b);
		// delete
		public void deleteBook(Project b);
}
