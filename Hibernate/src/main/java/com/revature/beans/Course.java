package com.revature.beans;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="UOP_COURSE")
public class Course {
	@Id
	@Column(name="COURSE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="COURSE_NAME")
	private String name;
	@Column(name="CREDITS")
	private int credits;
	
	//Mappings
	@ManyToMany
	@JoinTable(name="COURSE_REGISTRATION",
	joinColumns=@JoinColumn(name="COURSE_ID"),inverseJoinColumns=@JoinColumn(name="STUDENT_ID"))
	private Set<Student> students;
	@ManyToMany
	@JoinTable(name="TEXTBOOKS_TABLE",
	joinColumns=@JoinColumn(name="COURSE_ID"),inverseJoinColumns=@JoinColumn(name="STUDENT_ID"))
	private Set<Textbook> materials;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COURSE_INSTRUCTOR")
	private Teacher instructor;
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
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Teacher getInstructor() {
		return instructor;
	}
	public void setInstructor(Teacher instructor) {
		this.instructor = instructor;
	}
	public Set<Textbook> getMaterials() {
		return materials;
	}
	public void setMaterials(Set<Textbook> materials) {
		this.materials = materials;
	}
	public Course() {
		super();
	}
	public Course(int id, String name, int credits, Set<Student> students, Teacher instructor, Set<Textbook> materials) {
		super();
		this.id = id;
		this.name = name;
		this.credits = credits;
		this.students = students;
		this.instructor = instructor;
		this.materials = materials;
	}
	
}
