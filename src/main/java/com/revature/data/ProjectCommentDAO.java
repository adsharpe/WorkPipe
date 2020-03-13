package com.revature.data;

import java.util.Set;

import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Project;
import com.revature.hibernate.beans.ProjectComment;

public interface ProjectCommentDAO {
	// create
	public ProjectComment addProjectComment(ProjectComment pc);
	// read
	public ProjectComment getProjectComment(int i);
	public Set<ProjectComment> getProjectComments();
	public Set<ProjectComment> getProjectCommentsByProject(Project p);
	public Set<ProjectComment> getProjectCommentsByEmployee(Employee emp);
	// update
	public void updateProjectComment(ProjectComment pc);
	// delete
	public void deleteProjectComment(ProjectComment pc);
}
