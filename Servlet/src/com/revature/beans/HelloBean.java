package com.revature.beans;


public class HelloBean {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HelloBean() {
		super();
	}

	public HelloBean(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloBean [message=" + message + "]";
	}
	
}
