package com.revature.beans;

public class UserBean {
	private String fullname;
	private String email;
	private int age;
	private String username;
	private String password;
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserBean() {
		super();
	}
	public UserBean(String fullname, String email, int age, String username, String password) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.age = age;
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserBean [fullname=" + fullname + ", email=" + email + ", age=" + age + ", username=" + username
		    + ", password=" + "]";
	}
	
}
