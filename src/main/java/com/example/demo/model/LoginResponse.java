package com.example.demo.model;

public class LoginResponse {

	
	private boolean message;
	
	private String mobile;
	
	public LoginResponse() {
		// TODO Auto-generated constructor stub
	}

	public boolean getMessage() {
		return message;
	}

	public void setMessage(boolean message) {
		this.message =message;
	}

	public LoginResponse(boolean message, String mobile) {
		super();
		this.message = message;
		this.mobile = mobile;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "LoginResponse [message=" + message + ", mobile=" + mobile + "]";
	}
	
	
	
	
	
	
}
