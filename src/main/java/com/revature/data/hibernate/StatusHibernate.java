package com.revature.data.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.data.StatusDAO;
import com.revature.hibernate.beans.Status;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;
@Repository
public class StatusHibernate implements StatusDAO {
	private HibernateUtil hu = HibernateUtil.getInstance();
	//intentional error as a reminder to implement methods from DAO
	//error in syntax as
	@Override
	public Status addStatus(Status s) {
		Session sess = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = sess.beginTransaction();
			i = (Integer) sess.save(s);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
			LogUtil.logException(e, StatusHibernate.class);
		} finally {
			sess.close();
		}
		return s;
	}
	@Override
	public Status getStatus(int i) {
		Session sess = hu.getSession();
		String query = "from Status i where i.id=:id";
		Query<Status> q = sess.createQuery(query, Status.class);
		q.setParameter("id", i);
		Status s = q.uniqueResult();
		sess.close();
		return s;
	}
	@Override
	public Status getStatusById(Status s) {
		Session sess = hu.getSession();
		Status stat = sess.get(Status.class, s.getId());
		sess.close();
		return stat;
	}
	@Override
	public void updateStatus(Status s) {
		Session sess = hu.getSession();
		Transaction t = null;
		try{
			t = sess.beginTransaction();
			sess.update(s.getId());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, StatusHibernate.class);
		} finally {
			sess.close();
		}
	}
	@Override
	public void deleteStatus(Status s) {
		Session sess = hu.getSession();
		Transaction t = null;
		try{
			t = sess.beginTransaction();
			sess.delete(s.getId());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, StatusHibernate.class);
		} finally {
			sess.close();
		}
	} 
}
