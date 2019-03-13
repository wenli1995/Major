package com.java.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.model.User;
import com.java.util.HibernateUtil;

public class UserDao {
	public User Login(User manager){		
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="from User where userName=:userName and password=:password";
		Query query=session.createQuery(hql);
		query.setString("userName", manager.getUserName());
		query.setString("password", manager.getPassword());
		User resultManager=(User)query.uniqueResult();
		session.getTransaction().commit();
		return resultManager;
		
	}
}