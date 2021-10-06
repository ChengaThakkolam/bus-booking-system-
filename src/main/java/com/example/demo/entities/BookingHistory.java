package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="booking_history")
public class BookingHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String mobile;
	
	private String name;
	
	private String regId;
	
	private String seatNumber;
	
	private float price;
	
	private String createAt;
	
	private String fromCity;
	
	private String toCity;

	
	
			
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	
	public BookingHistory() {
		// TODO Auto-generated constructor stub
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	

	

	@Override
	public String toString() {
		return "BookingHistory [id=" + id + ", mobile=" + mobile + ", name=" + name + ", regId=" + regId
				+ ", seatNumber=" + seatNumber + ", price=" + price + ", createAt=" + createAt + ", fromCity="
				+ fromCity + ", toCity=" + toCity + "]";
	}

	public BookingHistory(String mobile, String name, String regId, String seatNumber, float price,
			String createAt, String fromCity, String toCity) {
		super();
		this.mobile = mobile;
		this.name = name;
		this.regId = regId;
		this.seatNumber = seatNumber;
		this.price = price;
		this.createAt = createAt;
		this.fromCity = fromCity;
		this.toCity = toCity;
	}

	


}
