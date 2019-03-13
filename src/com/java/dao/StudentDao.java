package com.java.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.java.model.Major;
import com.java.model.Student;
import com.java.util.HibernateUtil;
import com.java.util.StringUtil;

public class StudentDao {
	public boolean exitsStudentsByClassId(String c_id){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql="from Student where classId=:classId";
		Query query=session.createQuery(hql);
		query.setString("classId", c_id);
		List<Student> students=query.list();
		session.getTransaction().commit();
		if(students.size()>0){
			return true;
		}
		return false;
	}
	
	public List<Student> query (Student student){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		StringBuffer sb=new StringBuffer("from Student s ");
		if(student!=null&&StringUtil.isNotEmpty(student.getBirthplace())){
			sb.append(" and s.birthplace like '%"+student.getBirthplace()+"%'");
		}
		if(student!=null&&StringUtil.isNotEmpty(student.getSex())){
			sb.append(" and s.sex='"+student.getSex()+"'");
		}
		if(student!=null&&StringUtil.isNotEmpty(student.getStuName())){
			sb.append(" and s.stuName='"+student.getStuName()+"'");
		}
	
		if(student!=null&&student.getMajor().getId()!=0){
			sb.append(" and s.major.id="+student.getMajor().getId());
		}
		if(student!=null&&StringUtil.isNotEmpty(student.getMajor().getGrade())){
			sb.append(" and s.major.grade='"+student.getMajor().getGrade()+"'");
		}
		Query query=session.createQuery(sb.toString().replaceFirst("and", "where"));
		List<Student> studentList=query.list();
		session.getTransaction().commit();
		return studentList;

	}
	
	public Student getStudentById(int id){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Student student=(Student) session.get(Student.class, id);
		session.getTransaction().commit();
		return student;   //修改是使用该函数
	}
	public void save(Student student){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.merge(student);
		session.getTransaction().commit();
	}
	
	public void delete(Student student){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(student);
		session.getTransaction().commit();
	}
}
