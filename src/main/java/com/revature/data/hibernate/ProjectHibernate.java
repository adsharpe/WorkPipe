package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.data.ProjectDAO;
import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Project;
import com.revature.hibernate.beans.Task;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class ProjectHibernate implements ProjectDAO{
	private HibernateUtil hu = HibernateUtil.getInstance();
		@Override
		public Project addProject(Project p) {
			Session s = hu.getSession();
			Transaction tx = null;
			try {
				tx = s.beginTransaction();
				s.save(p);
				tx.commit();
			} catch(Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				LogUtil.logException(e, ProjectHibernate.class);
			} finally {
				s.close();
			}
			return p;
		}
		@Override
		public Project getProject(int i) {
			Session s = hu.getSession();
			Project p = s.get(Project.class, i);
			s.close();
			return p;
		}
		@Override
		public Project getProjectByTask(Task t) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Set<Project> getProjects() {
			Session s = hu.getSession();
			String query = "FROM Project";
			Query<Project> q = s.createQuery(query, Project.class);
			List<Project> projectList = q.getResultList();
			Set<Project> projectSet = new HashSet<Project>();
			projectSet.addAll(projectList);
			s.close();
			return projectSet;
		}
		@Override
		public Set<Project> getProjectsByEmployee(Employee emp) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void updateProject(Project p) {
			Session s = hu.getSession();
			Transaction tx = null;
			try {
				tx = s.beginTransaction();
				s.update(p);
				tx.commit();
			} catch(Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				LogUtil.logException(e, ProjectHibernate.class);
			} finally {
				s.close();
			}
		}
		@Override
		public void deleteProject(Project p) {
			Session s = hu.getSession();
			Transaction tx = null;
			try {
				tx = s.beginTransaction();
				s.delete(p);
				tx.commit();
			} catch(Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				LogUtil.logException(e, ProjectHibernate.class);
			} finally {
				s.close();
			}
		}
}
