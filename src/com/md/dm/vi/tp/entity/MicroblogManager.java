package com.md.dm.vi.tp.entity;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;

import util.HibernateUtil;

public class MicroblogManager {

	public MicroblogManager() {
	}
	
	public List<Microblog> all() throws Exception{
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List results = session.createQuery( "select m from Microblog m" ).list();
		session.getTransaction().commit();
		return results;
	}
	
	
	
}
