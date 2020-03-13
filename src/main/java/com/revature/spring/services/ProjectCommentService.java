package com.revature.spring.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.ProjectCommentDAO;
import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Project;
import com.revature.hibernate.beans.ProjectComment;

@Service
@Transactional(readOnly=true)
public class ProjectCommentService {
	@Autowired
	ProjectCommentDAO projectCommentDao;
	
	@Transactional(readOnly=false)
	public ProjectComment addProjectComment(ProjectComment projectComment) {
		return projectCommentDao.addProjectComment(projectComment);
	}
	
	// read
	public ProjectComment getProjectComment(int projectCommentId) {
		return projectCommentDao.getProjectComment(projectCommentId);
	}
	
	public Set<ProjectComment> getProjectComments() {
		return projectCommentDao.getProjectComments();
	}
	
	public Set<ProjectComment> getProjectCommentsByProject(Project project) {
		return projectCommentDao.getProjectCommentsByProject(project);
	}
	
	public Set<ProjectComment> getProjectCommentsByEmployee(Employee employee) {
		return projectCommentDao.getProjectCommentsByEmployee(employee);
	}

	@Transactional(readOnly=false)
	public void updateProjectComment(ProjectComment projectComment) {
		projectCommentDao.updateProjectComment(projectComment);
	}

	@Transactional(readOnly=false)
	public void deleteProjectComment(ProjectComment projectComment) {
		projectCommentDao.deleteProjectComment(projectComment);
	}
}
