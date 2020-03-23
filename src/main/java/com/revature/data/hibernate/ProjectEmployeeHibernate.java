package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.data.ProjectEmployeeDAO;
import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.ProjectEmployee;
import com.revature.hibernate.beans.Project;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;
@Repository
public class ProjectEmployeeHibernate implements ProjectEmployeeDAO {
	private HibernateUtil hu = HibernateUtil.getInstance();
		@Override
		public ProjectEmployee addProjectEmployee(ProjectEmployee projectEmployee) {
			Session s = hu.getSession();
			Transaction t = null;

			try {
				t = s.beginTransaction();
				s.save(projectEmployee);
				t.commit();
			} catch(HibernateException e) {
				t.rollback();
				LogUtil.logException(e, ProjectEmployeeHibernate.class);
			} finally {
				s.close();
			}
			return projectEmployee;
		}
		@Override
		public ProjectEmployee getProjectEmployee(int projectEmployeeId) {
			Session s = hu.getSession();
			ProjectEmployee projectEmployee = s.get(ProjectEmployee.class, projectEmployeeId);
			s.close();
			return projectEmployee;
		}
		@Override
		public Set<ProjectEmployee> getProjectEmployeesByProject(Project project) {
			Session s = hu.getSession();
			//first projId might actually be column name "project_id"
			String query = "from Project_Employee where projId=:projId";
			Query<ProjectEmployee> q = s.createQuery(query, ProjectEmployee.class);
			q.setParameter("projId", project.getId());
			Set<ProjectEmployee> groupSet = new HashSet<ProjectEmployee>();
			List<ProjectEmployee> groupList = q.getResultList();
			groupSet.addAll(groupList);
			s.close();
			return groupSet;
		}
		@Override
		public Set<ProjectEmployee> getProjectEmployeesByEmployee(Employee emp) {
			Session s = hu.getSession();
			String query = "from Project_Employee p where :employee = some elements(p.employees)";
			Query<ProjectEmployee> q = s.createQuery(query, ProjectEmployee.class);
			q.setParameter("employees", emp);
			List<ProjectEmployee> groupList = q.getResultList();
			Set<ProjectEmployee> groupSet = new HashSet<ProjectEmployee>();
			groupSet.addAll(groupList);
			s.close();
			return groupSet;
		}
		@Override
		public void updateProjectEmployee(ProjectEmployee p) {
			Session s = hu.getSession();
			Transaction t = null;
			try{
				t = s.beginTransaction();
				s.update(p.getId());
				t.commit();
			} catch(Exception e) {
				if(t != null)
					t.rollback();
				LogUtil.logException(e, ProjectEmployeeHibernate.class);
			} finally {
				s.close();
			}
		}
		
		@Override
		public void deleteProjectEmployee(ProjectEmployee p) {
			Session s = hu.getSession();
			Transaction t = null;
			try{
				t = s.beginTransaction();
				//this is the better delete
				s.delete(p);
				t.commit();
			} catch(Exception e) {
				if(t != null)
					t.rollback();
				LogUtil.logException(e, ProjectEmployeeHibernate.class);
			} finally {
				s.close();
			}
		} 
}
