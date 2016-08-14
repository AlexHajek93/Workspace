package com.revature.Hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Classroom;
import com.revature.beans.Course;
import com.revature.beans.Student;
import com.revature.beans.Teacher;
import com.revature.beans.Textbook;
/**
 * Hello world!
 *
 */
public class App 
{
//	public static void main(String[] args) {
//		Employee object = new Employee(1,"Dan","Pickles",20000,new Date(),true);
//		DataLayer dataServiceLayer = new DataLayer();
//		dataServiceLayer.createRecord(object);
//	}
	
	private Session session;
	public static void main(String[] args) {
		App app = new App();
		app.session = SessionFactoryManager.getInstance().openSession();
		Transaction tx = app.session.beginTransaction();
		Classroom classroom = new Classroom(1,205,"John Hancock");
		app.session.save(classroom);
		Teacher teacher = new Teacher(1,"Bill Gates","CS",null,classroom);
		app.session.save(teacher);
		Set<Textbook> books = new HashSet<Textbook>();
		Textbook headFirst = new Textbook(1,"6541189764531","Head First Java","Dan Pickles",2005,null);
		books.add(headFirst);
		app.session.save(headFirst);
		Course java = new Course(1,"Intro to Java",3,null,teacher,books);
		app.session.save(java);
		Set<Course> courses = new HashSet<Course>();
		Student alpha = new Student(1,"Alpha","EE",new Date(),courses);
		Student beta = new Student(1,"Beta","EE",new Date(),courses);
		app.session.save(alpha);
		app.session.save(beta);
		tx.commit();
	}
}
