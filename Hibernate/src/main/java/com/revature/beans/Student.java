package com.revature.beans;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Cacheable
//org.hibernate.annotations.Cache(usage=CacheConcurrencyStrategy.READ_ONLY);
//For reading only
@Entity
@Table(name="UOP_STUDENT")
public class Student {
	@Id
	@Column(name="STUDENT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="FULL_NAME")
	private String name;
	@Column
	private String major;
	@Column(name="ENROLLMENT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date enrollmentDate;
	//Mappings
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="students")
	private Set<Course> enrolledCourses;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Date getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	public Set<Course> getEnrolledCourses() {
		return enrolledCourses;
	}
	public void setEnrolledCourses(Set<Course> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}
	public Student() {
		super();
	}
	public Student(int id, String name, String major, Date enrollmentDate, Set<Course> enrolledCourses) {
		super();
		this.id = id;
		this.name = name;
		this.major = major;
		this.enrollmentDate = enrollmentDate;
		this.enrolledCourses = enrolledCourses;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", major=" + major + ", enrollmentDate=" + enrollmentDate + "]";
	}
	
}
