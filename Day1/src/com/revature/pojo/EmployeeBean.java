package com.revature.pojo;

import java.util.Date;

/**
 * 
 * JavaBean Specs
 * @author Alex
 */

public class EmployeeBean {
	
	//1. encapsulated
	private int ssn;
	private String firstName;
	private String lastName;
	private Date dob;
	private boolean active;
	
	//2. Getters/setters follow naming convention
	//getSsn setSsn   isActive setActive
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	//3. Constructors - Must have empty constructor
	public EmployeeBean() {
		super();
	}
	public EmployeeBean(int ssn, String firstName, String lastName, Date dob, boolean active) {
		this();
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.active = active;
	}
	
	
}
