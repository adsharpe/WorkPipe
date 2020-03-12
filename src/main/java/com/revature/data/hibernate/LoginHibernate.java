package com.revature.data.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.data.LoginDAO;
import com.revature.hibernate.beans.Login;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class LoginHibernate implements LoginDAO {
	private HibernateUtil hu = HibernateUtil.getInstance();
	@Override
	public int addUser(Login user) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(user);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
			LogUtil.logException(e, LoginHibernate.class);
		} finally {
			s.close();
		}
		return i;
	}

	@Override
	public Login getLogin(String username, String password) {
		Session s = hu.getSession();
		String query = "from Login l where l.username=:username and l.password=:password";
		Query<Login> q = s.createQuery(query, Login.class);
		q.setParameter("username", username);
		q.setParameter("password", password);
		Login u = q.uniqueResult();
		s.close();
		return u;
	}

	@Override
	public Login getLogin(Login l) {
		Session s = hu.getSession();
		Login ret = s.get(Login.class, l.getId());
		if(ret==null) {
			String query = "from User u where u.username=:username and u.password=:password";
			Query<Login> q = s.createQuery(query, Login.class);
			q.setParameter("username", l.getUsername());
			q.setParameter("password", l.getPassword());
			ret = q.uniqueResult();
		}
		s.close();
		return ret;
	}

	@Override
	public Login getLoginById(Login l) {
		Session s = hu.getSession();
		Login ret = s.get(Login.class, l.getId());
		s.close();
		return ret;
	}

	@Override
	public void deleteLogin(Login l) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(l.getId());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, LoginHibernate.class);
		} finally {
			s.close();
		}
	}

	@Override
	public void updateLogin(Login l) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(l.getId());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, LoginHibernate.class);
		} finally {
			s.close();
		}
	}

}
