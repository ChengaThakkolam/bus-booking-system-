package com.example.demo.model;


public class UserRegistrationRequest {

		
	private String name;
	
	private String email;
	
	private String gender;
	
	private String dob;
	
	private String mobile;
	
	private String password;
		
	private float wallet;

	
	public UserRegistrationRequest() {
		// TODO Auto-generated constructor stub
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
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


	public float getWallet() {
		return wallet;
	}


	public void setWallet(float wallet) {
		this.wallet = wallet;
	}


	@Override
	public String toString() {
		return "UserRegistrationRequest[ name=" + name + ", email=" + email + ", gender=" + gender + ", dob=" + dob +  ", mobile=" + mobile
				+ ", password=" + password + ", wallet=" + wallet + "]";
	}

	
	
}
