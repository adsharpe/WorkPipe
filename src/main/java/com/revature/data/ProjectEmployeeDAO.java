package com.revature.data;

import java.util.Set;

import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.ProjectEmployee;
import com.revature.hibernate.beans.Project;

public interface ProjectEmployeeDAO {
	// create
	public ProjectEmployee addProjectEmployee(ProjectEmployee projectEmployee);
	// read
	public ProjectEmployee getProjectEmployee(int projectEmployeeId);
	public ProjectEmployee getProjectEmployeeByProject(Project project);
	public Set<ProjectEmployee> getProjectEmployeeByEmployee(Employee employee);
	// update
	public void updateGroup(ProjectEmployee projectEmployee);
	// delete
	public void deleteGroup(ProjectEmployee projectEmployee);
}
