package com.revature.beans;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="UOP_TEACHER")
public class Teacher {
	@Id
	@Column(name="TEACHER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="TEACHER_NAME")
	private String name;
	@Column(name="DEPARTMENT")
	private String department;
	
	//Mappings
	@OneToMany(mappedBy="instructor")
	private Set<Course> assinedCourses;
	@OneToOne
	@JoinColumn(name="DESIGNATED_CLASSROOM")
	private Classroom classroom;

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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Set<Course> getAssinedCourses() {
		return assinedCourses;
	}
	public void setAssinedCourses(Set<Course> assinedCourses) {
		this.assinedCourses = assinedCourses;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public Teacher() {
		super();
	}
	public Teacher(int id, String name, String department, Set<Course> assinedCourses, Classroom classroom) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.assinedCourses = assinedCourses;
		this.classroom = classroom;
	}
	
}
