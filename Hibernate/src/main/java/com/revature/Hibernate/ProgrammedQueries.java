package com.revature.Hibernate;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Student;

public class ProgrammedQueries {
	public static void main(String[] args) {
		String sql = "select * from tablename where id = ?";
		
		Session session = SessionFactoryManager.getInstance().openSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("name", "Alpha"));
		
		Set<Student> results =(Set<Student>) criteria.list();
		for(Student a:results){
			System.out.println();
		}
	}
}
