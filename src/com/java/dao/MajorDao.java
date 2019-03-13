package com.java.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.java.model.Major;
import com.java.model.Student;
import com.java.util.HibernateUtil;
import com.java.util.StringUtil;

public class MajorDao {
	public List<Major> query (Major major){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		StringBuffer sb=new StringBuffer("from Major");
		if(major!=null&&StringUtil.isNotEmpty(major.getGrade())){
			sb.append(" and grade='"+major.getGrade()+"'");
		}
		if(major!=null&&StringUtil.isNotEmpty(major.getClassName())){
			sb.append(" and className like '%"+major.getClassName()+"%'");
		}
		Query query=session.createQuery(sb.toString().replaceFirst("and", "where"));
		List<Major> classList=query.list();
		for(Major stuClass:classList){
			Set<Student> students=stuClass.getStudents();
			int amount=students.size();
			stuClass.setStuAmount(amount);
		}
		session.getTransaction().commit();
		return classList;

	}
	
	public Major getClassById(int id){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Major major=(Major) session.get(Major.class, id);
		session.getTransaction().commit();
		return major;   //修改是使用该函数
	}
	public void add(Major major){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.merge(major);
		session.getTransaction().commit();
	}
	
	public void delete(Major major){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(major);
		session.getTransaction().commit();
	}

}
