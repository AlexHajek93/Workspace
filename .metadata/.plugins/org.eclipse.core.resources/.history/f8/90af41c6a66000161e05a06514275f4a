package com.revature.Session;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.revature.Hibernate.SessionFactoryManager;
import com.revature.beans.Student;

public class Loading {
	public static void main(String[] args) {
		Session session = SessionFactoryManager.getInstance().openSession();
		
		//Native SQL
		String sqlN = "SELECT * FROM UOP_STUDENT WHERE STUDENT_ID=?";
		SQLQuery queryN = session.createSQLQuery(sqlN);
		queryN.setInteger(0, 48);
		//Bind to a class managed by Hibernate
		queryN.addEntity(Student.class);
		Student abc = (Student) queryN.uniqueResult();
		System.out.println(abc);
		//Using get will return null with invalid
		Student alpha = (Student) session.get(Student.class, 47);
		//Using load will give error with invalid id
		//Load is faster tho...
		//Student alpha = (Student) session.load(Student.class, 47);
		System.out.println(alpha);
		//HQL (OO v of SQL)
		String sql = "SELECT * FROM UOP_STUDENT WHERE STUDENT_ID=?";
		//can drop com.rev...
		//Also case sensitive now...
		String hql = "FROM com.revature.beans.Student WHERE id=:param";
		Query query = session.createQuery(hql);
		query.setInteger("param", 47);
		Student record = (Student)query.uniqueResult();
		//Multiple
		//List<Student> list = query.list();
		System.out.println(record);
		//System.out.println(list);
	}
}
