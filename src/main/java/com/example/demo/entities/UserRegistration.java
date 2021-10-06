package com.example.demo.entities;


import java.time.LocalDateTime;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Registration")
public class UserRegistration {

	@Id	
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String regId;
	
	private String name;
	
	
	private String email;
	
	private int age;
	
	
	private String gender;
	
	
	
	private String dob;
	
	@CreationTimestamp
	private LocalDateTime regDateTime;
	
	
	private String mobile;
	
	private String password;
	
	private boolean loginStatus;
	
	@OneToOne(targetEntity = Wallet.class, cascade = CascadeType.ALL)
	private Wallet wallet;

	
	
	public UserRegistration() {
		// TODO Auto-generated constructor stub
	}



	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}
	

	
	public String getRegId() {
		return regId;
	}

	public boolean getLoginstatus() {
		return loginStatus;

	}

	public void setRegId(String regId) {
		this.regId = regId;
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



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
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



	public LocalDateTime getRegDateTime() {
		return regDateTime;
	}



	public void setRegDateTime(LocalDateTime regDateTime) {
		this.regDateTime = regDateTime;
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



	public Wallet getWallet() {
		return wallet;
	}



	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}



	public UserRegistration(String regId, String name, String email, int age, String gender, String dob,
			LocalDateTime regDateTime, String mobile, String password, Wallet wallet) {
		super();
		this.regId = regId;
		this.name = name;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.dob = dob;
		this.regDateTime = regDateTime;
		this.mobile = mobile;
		this.password = password;
		this.wallet = wallet;
	}



	@Override
	public String toString() {
		return "UserRegistration [regId=" + regId + ", name=" + name + ", email=" + email + ", age=" + age + ", gender="
				+ gender + ", dob=" + dob + ", regDateTime=" + regDateTime + ", mobile=" + mobile + ", password="
				+ password + ", wallet=" + wallet + "]";
	}
	
	
	
	
	




		
}
