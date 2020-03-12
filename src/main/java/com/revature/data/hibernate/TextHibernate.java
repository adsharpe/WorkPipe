package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.data.TextDAO;
import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Project;
import com.revature.hibernate.beans.Task;
import com.revature.hibernate.beans.Text;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class TextHibernate implements TextDAO {
	private HibernateUtil hibernateUtil = HibernateUtil.getInstance();

	@Override
	public int addText(Text text) {
		Session session = hibernateUtil.getSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.save(text);
			transaction.commit();
		} catch(HibernateException ex) {
			if(transaction != null)
				transaction.rollback();
			LogUtil.logException(ex, TextHibernate.class);
		} finally {
			session.close();
		}
		
		return text.getId();
	}

	@Override
	public Text getText(int textId) {
		Session session = hibernateUtil.getSession();
		Text text = null;
		
		try {
			text = session.get(Text.class, textId);
		} catch(HibernateException ex) {
			LogUtil.logException(ex, TextHibernate.class);
		} finally {
			session.close();
		}
		
		return text;
	}

	@Override
	public Text getTextByEmployee(Employee emp) {
		// TODO Remove this call from DAO interface
		return null;
	}

	@Override
	public Set<Text> getTexts() {
		Session session = hibernateUtil.getSession();
		Set<Text> texts = new HashSet<Text>();
		
		try {
			String query = "SELECT * FROM text";
			Query<Text> queries = session.createQuery(query, Text.class);
			List<Text> textList = queries.getResultList();
			Set<Text> textSet = new HashSet<Text>();
			textSet.addAll(textList);
		} catch(HibernateException ex) {
			LogUtil.logException(ex, TextHibernate.class);
		} finally {
			session.close();
		}
		
		return texts;
	}

	@Override
	public Set<Text> getTextsByProject(Project p) {
		// TODO Remove this call from DAO interface
		return null;
	}

	@Override
	public Set<Text> getTextsByTask(Task t) {
		// TODO Remove this call from DAO interface
		return null;
	}

	@Override
	public void updateText(Text text) {
		Session session = hibernateUtil.getSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.update(text);
			transaction.commit();
		} catch(HibernateException ex) {
			if(transaction != null)
				transaction.rollback();
			LogUtil.logException(ex, TextHibernate.class);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteText(Text text) {
		Session session = hibernateUtil.getSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.delete(text);
			transaction.commit();
		} catch(HibernateException ex) {
			if(transaction != null)
				transaction.rollback();
			LogUtil.logException(ex, TextHibernate.class);
		} finally {
			session.close();
		}
	}
}
