package com.md.dm.vi.tp.entity;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;

public class WordTagManager {

	public List<WordTag> all() throws Exception{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List results = session.createQuery( "select w from WordTag w" ).list();
		session.getTransaction().commit();
		return results;
	}

	public List<WordTag> allAbove(int umbral) throws Exception{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List results = session.createQuery( "select w from WordTag w where w.count <" + umbral).list();
		session.getTransaction().commit();
		return results;
	}
}
