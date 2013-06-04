package com.github.alexdp.vaadin7.sandbox.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class HibernateExampleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
//	public void insert(RemoteHeartBeatBean bean) {
//		sessionFactory.getCurrentSession().persist(bean);
//	}
//	
//	public List<RemoteHeartBeatBean> findAll() {
//		return sessionFactory.getCurrentSession().createCriteria(RemoteHeartBeatBean.class).list();
//	}
	
}
