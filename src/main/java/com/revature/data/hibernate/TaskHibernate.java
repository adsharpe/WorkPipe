package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.data.TaskDAO;
import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Project;
import com.revature.hibernate.beans.Status;
import com.revature.hibernate.beans.Task;
import com.revature.hibernate.beans.Text;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class TaskHibernate implements TaskDAO {
	private HibernateUtil hibernateUtil = HibernateUtil.getInstance();

	@Override
	public Task addTask(Task task) {
		Session session = hibernateUtil.getSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.save(task);
			transaction.commit();
		} catch(HibernateException ex) {
			if(transaction != null)
				transaction.rollback();
			LogUtil.logException(ex, TaskHibernate.class);
		} finally {
			session.close();
		}
		
		return task;
	}

	@Override
	public Task getTask(int taskId) {
		Session session = hibernateUtil.getSession();
		Task task = null;
		
		try {
			task = session.get(Task.class, taskId);
		} catch(HibernateException ex) {
			LogUtil.logException(ex, TaskHibernate.class);
		} finally {
			session.close();
		}
		
		return task;
	}

	@Override
	public Set<Task> getTasksByProject(Project project) {
		Session session = hibernateUtil.getSession();
		Set<Task> tasks = new HashSet<Task>();
		
		try {
			String query = "SELECT * FROM task WHERE project_id:project_id";
			Query<Task> queries = session.createQuery(query, Task.class);
			List<Task> taskList = queries.getResultList();
			Set<Task> taskSet = new HashSet<Task>();
			taskSet.addAll(taskList);
		} catch(HibernateException ex) {
			LogUtil.logException(ex, TextHibernate.class);
		} finally {
			session.close();
		}
		
		return tasks;
	}

	@Override
	public Set<Task> getTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Task> getTasksByStatus(Status status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Task> getTasksByEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTask(Task task) {
		Session session = hibernateUtil.getSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.update(task);
			transaction.commit();
		} catch(HibernateException ex) {
			if(transaction != null)
				transaction.rollback();
			LogUtil.logException(ex, TaskHibernate.class);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteTask(Task task) {
		Session session = hibernateUtil.getSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.delete(task);
			transaction.commit();
		} catch(HibernateException ex) {
			if(transaction != null)
				transaction.rollback();
			LogUtil.logException(ex, TaskHibernate.class);
		} finally {
			session.close();
		}
	}
}
