package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.data.GroupDAO;
import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Group;
import com.revature.hibernate.beans.Project;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class GroupHibernate implements GroupDAO {
	private HibernateUtil hu = HibernateUtil.getInstance();
		@Override
		public int addGroup(Group g) {
			Session s = hu.getSession();
			Transaction t = null;
			Integer i = 0;
			try {
				t = s.beginTransaction();
				i = (Integer) s.save(g);
				t.commit();
			} catch(HibernateException e) {
				t.rollback();
				LogUtil.logException(e, GroupHibernate.class);
			} finally {
				s.close();
			}
			return i;
		}
		@Override
		public Group getGroup(int i) {
			Session s = hu.getSession();
			Group g = s.get(Group.class, i);
			s.close();
			return g;
		}
		@Override
		public Group getGroupByProject(Project p) {
			Group g;
			Session s = hu.getSession();
			//first projId might actually be column name "project_id"
			String query = "from Group where projId=:projId";
			Query<Group> q = s.createQuery(query, Group.class);
			q.setParameter("projId", p.getId());
			g = q.uniqueResult();
			s.close();
			return g;
		}
		@Override
		public Set<Group> getGroupsByEmployee(Employee emp) {
			Session s = hu.getSession();
			String query = "FROM Group g where :employee = some elements(g.employees)";
			Query<Group> q = s.createQuery(query, Group.class);
			q.setParameter("employees", emp);
			List<Group> groupList = q.getResultList();
			Set<Group> groupSet = new HashSet<Group>();
			groupSet.addAll(groupList);
			s.close();
			return groupSet;
		}
		@Override
		public void updateGroup(Group g) {
			Session s = hu.getSession();
			Transaction t = null;
			try{
				t = s.beginTransaction();
				s.update(g.getId());
				t.commit();
			} catch(Exception e) {
				if(t != null)
					t.rollback();
				LogUtil.logException(e, GroupHibernate.class);
			} finally {
				s.close();
			}
		}
		
		@Override
		public void deleteGroup(Group g) {
			Session s = hu.getSession();
			Transaction t = null;
			try{
				t = s.beginTransaction();
				//this is the better delete
				s.delete(g);
				t.commit();
			} catch(Exception e) {
				if(t != null)
					t.rollback();
				LogUtil.logException(e, GroupHibernate.class);
			} finally {
				s.close();
			}
		} 
}
