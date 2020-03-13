package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.data.TaskCommentDAO;
import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Task;
import com.revature.hibernate.beans.TaskComment;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;
@Repository
public class TaskCommentHibernate implements TaskCommentDAO {
	private HibernateUtil hu = HibernateUtil.getInstance();
		@Override
		public TaskComment addTaskComment(TaskComment tc) {
			Session s = hu.getSession();
			Transaction tx = null;
			try {
				tx = s.beginTransaction();
				s.save(tc);
				tx.commit();
			} catch(Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				LogUtil.logException(e, TaskCommentHibernate.class);
			} finally {
				s.close();
			}
			return tc;
		}
		@Override
		public TaskComment getTaskComment(int i) {
			Session s = hu.getSession();
			TaskComment tc = s.get(TaskComment.class, i);
			s.close();
			return tc;
		}
		@Override
		public Set<TaskComment> getTaskComments() {
			Session s = hu.getSession();
			String query = "FROM TaskComment";
			Query<TaskComment> q = s.createQuery(query, TaskComment.class);
			List<TaskComment> taskCommentList = q.getResultList();
			Set<TaskComment> taskCommentSet = new HashSet<TaskComment>();
			taskCommentSet.addAll(taskCommentList);
			s.close();
			return taskCommentSet;
		}
		@Override
		public Set<TaskComment> getTaskCommentsByTask(Task t) {
			Session s = hu.getSession();
			String query = "FROM TaskComment tc where :task = some elements(tc.projects)";
			Query<TaskComment> q = s.createQuery(query, TaskComment.class);
			q.setParameter("task", t);
			List<TaskComment> taskCommentList = q.getResultList();
			Set<TaskComment> taskCommentSet = new HashSet<TaskComment>();
			taskCommentSet.addAll(taskCommentList);
			s.close();
			return taskCommentSet;
		}
		@Override
		public Set<TaskComment> getTaskCommentsByEmployee(Employee emp) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void updateTaskComment(TaskComment tc) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void deleteTaskComment(TaskComment tc) {
			// TODO Auto-generated method stub
			
		}
}
