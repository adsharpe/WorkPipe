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
	public Set<ProjectEmployee> getProjectEmployees();
	public Set<ProjectEmployee> getProjectEmployeesByProject(Project project);
	public Set<ProjectEmployee> getProjectEmployeesByEmployee(Employee employee);
	// update
	public void updateProjectEmployee(ProjectEmployee projectEmployee);
	// delete
	public void deleteProjectEmployee(ProjectEmployee projectEmployee);
}
