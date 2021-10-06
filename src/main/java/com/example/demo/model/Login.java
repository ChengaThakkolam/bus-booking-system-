package com.example.demo.model;

public class Login {
	
	private String mobile;
	
	private String password;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [mobile=" + mobile + ", password=" + password + "]";
	}
	
	

}
