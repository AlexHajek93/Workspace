package com.revature.Hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.beans.Employee;
import com.revature.beans.Student;

public class HibDAO {
	private Session session;
		
	public HibDAO() {
		super();
	}

	public HibDAO(Session session) {
		super();
		this.session = session;
	}

	public void insert(Object obj){
		session.save(obj);
	}
	
	public List<Employee> getAllEmployees(){
		Query query =session.createQuery("FROM EMPLOYEE");
		return query.list();
	}
	
	public List<Student> getByMajor(String major){
		Query query =session.createQuery("FROM Student WHERE major= :major");
		query.setString("major", major);
		return query.list();
	}
}
