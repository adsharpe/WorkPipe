package com.revature.data.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.data.CommuniqueTypeDAO;
import com.revature.hibernate.beans.CommuniqueType;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class CommuniqueTypeHibernate implements CommuniqueTypeDAO{
	private HibernateUtil hu = HibernateUtil.getInstance();
		@Override
		public CommuniqueType addCommuniqueType(CommuniqueType ct) {
			Session s = hu.getSession();
			Transaction tx = null;
			try {
				tx = s.beginTransaction();
				s.save(ct);
				tx.commit();
			} catch(Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				LogUtil.logException(e, CommuniqueTypeHibernate.class);
			} finally {
				s.close();
			}
			return ct;
		}
		@Override
		public CommuniqueType getCommuniqueType(int i) {
			Session s = hu.getSession();
			CommuniqueType ct = s.get(CommuniqueType.class, i);
			s.close();
			return ct;
		}
		
		@Override
		public void updateCommuniqueType(CommuniqueType ct) {
			Session s = hu.getSession();
			Transaction tx = null;
			try {
				tx = s.beginTransaction();
				s.update(ct);
				tx.commit();
			} catch(Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				LogUtil.logException(e, CommuniqueTypeHibernate.class);
			} finally {
				s.close();
			}
		}
		@Override
		public void deleteCommuniqueType(CommuniqueType ct) {
			Session s = hu.getSession();
			Transaction tx = null;
			try {
				tx = s.beginTransaction();
				s.delete(ct);
				tx.commit();
			} catch(Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				LogUtil.logException(e, CommuniqueTypeHibernate.class);
			} finally {
				s.close();
			}
		}
}
