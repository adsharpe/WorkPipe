package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.data.ProjectCommentDAO;
import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Project;
import com.revature.hibernate.beans.ProjectComment;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;
@Repository
public class ProjectCommentHibernate implements ProjectCommentDAO{
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public ProjectComment addProjectComment(ProjectComment pc) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(pc);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, ProjectCommentHibernate.class);
		} finally {
			s.close();
		}
		return pc;
	}

	@Override
	public ProjectComment getProjectComment(int i) {
		Session s = hu.getSession();
		ProjectComment pc = s.get(ProjectComment.class, i);
		s.close();
		return pc;
	}

	@Override
	public Set<ProjectComment> getProjectComments() {
		Session s = hu.getSession();
		String query = "FROM ProjectComment";
		Query<ProjectComment> q = s.createQuery(query, ProjectComment.class);
		List<ProjectComment> projectCommentList = q.getResultList();
		Set<ProjectComment> projectCommentSet = new HashSet<ProjectComment>();
		projectCommentSet.addAll(projectCommentList);
		s.close();
		return projectCommentSet;
	}

	@Override
	public Set<ProjectComment> getProjectCommentsByProject(Project p) {
		Session s = hu.getSession();
		String query = "FROM ProjectComment pc where :project = some elements(pc.projects)";
		Query<ProjectComment> q = s.createQuery(query, ProjectComment.class);
		q.setParameter("project", p);
		List<ProjectComment> projectCommentList = q.getResultList();
		Set<ProjectComment> projectCommentSet = new HashSet<ProjectComment>();
		projectCommentSet.addAll(projectCommentList);
		s.close();
		return projectCommentSet;
	}

	@Override
	public Set<ProjectComment> getProjectCommentsByEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProjectComment(ProjectComment pc) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(pc);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, ProjectCommentHibernate.class);
		} finally {
			s.close();
		}
	}

	@Override
	public void deleteProjectComment(ProjectComment pc) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(pc);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, ProjectCommentHibernate.class);
		} finally {
			s.close();
		}
	}
	
}
