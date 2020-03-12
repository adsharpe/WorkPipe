package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.data.CommuniqueDAO;
import com.revature.hibernate.beans.Communique;
import com.revature.hibernate.beans.CommuniqueType;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class CommuniqueHibernate implements CommuniqueDAO {
	private HibernateUtil hu = HibernateUtil.getInstance();

		@Override
		public Communique addCommuniqueType(Communique c) {
			Session s = hu.getSession();
			Transaction tx = null;
			try {
				tx = s.beginTransaction();
				s.save(c);
				tx.commit();
			} catch(Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				LogUtil.logException(e, CommuniqueHibernate.class);
			} finally {
				s.close();
			}
			return c;
		}

		@Override
		public Communique getCommunique(int i) {
			Session s = hu.getSession();
			Communique c = s.get(Communique.class, i);
			s.close();
			return c;
		}

		@Override
		public Set<Communique> getCommuniqueByCommuniqueType(CommuniqueType ct) {
			Session s = hu.getSession();
			String query = "FROM Communique c where :commType = some elements(c.commTypes)";
			Query<Communique> q = s.createQuery(query, Communique.class);
			q.setParameter("commTypes", ct);
			List<Communique> communiqueList = q.getResultList();
			Set<Communique> communiqueSet = new HashSet<Communique>();
			communiqueSet.addAll(communiqueList);
			s.close();
			return communiqueSet;
		}

		@Override
		public void updateCommunique(Communique c) {
			Session s = hu.getSession();
			Transaction tx = null;
			try {
				tx = s.beginTransaction();
				s.update(c);
				tx.commit();
			} catch(Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				LogUtil.logException(e, CommuniqueHibernate.class);
			} finally {
				s.close();
			}
		}

		@Override
		public void deleteCommunique(Communique c) {
			Session s = hu.getSession();
			Transaction tx = null;
			try {
				tx = s.beginTransaction();
				s.delete(c);
				tx.commit();
			} catch(Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				LogUtil.logException(e, CommuniqueHibernate.class);
			} finally {
				s.close();
			}
		}
		
}
