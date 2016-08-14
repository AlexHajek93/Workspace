package com.revature.beans;

public class Trainee {
	
	private int id;
	private String name;
	private String major;
	private double salary;
	private Skill skill;//HAS-A
	
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public Trainee() {
		super();
	}
	public Trainee(int id, String name, String major, double salary, Skill skill) {
		super();
		this.id = id;
		this.name = name;
		this.major = major;
		this.salary = salary;
		this.skill = skill;
	}
	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", major=" + major + ", salary=" + salary + ", skill=" + skill
		    + "]";
	}
	
}
