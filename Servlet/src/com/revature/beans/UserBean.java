package com.revature.beans;

public class UserBean {
	private String username;
	private String password;
	private String fullname = "Dan Pickles";
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public UserBean() {
		super();
	}
	public UserBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserBean [username=" + username + ", password=" + password + ", fullname=" + fullname + "]";
	}
	
	
}
