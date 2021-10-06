package com.example.demo.entities;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="wallet")
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int  wallet_id;
	
	private String regId;
	
	private BigDecimal balance;    	// (10,2)
	
	@CreationTimestamp
	private LocalDateTime createAt;
	
	
	
	public Wallet() {
		// TODO Auto-generated constructor stub
	}



	public Wallet(int wallet_id, String regId, BigDecimal balance, LocalDateTime createAt) {
		super();
		this.wallet_id = wallet_id;
		this.regId = regId;
		this.balance = balance;
		this.createAt = createAt;
	}



	public int getWallet_id() {
		return wallet_id;
	}



	public void setWallet_id(int wallet_id) {
		this.wallet_id = wallet_id;
	}



	public String getRegId() {
		return regId;
	}



	public void setRegId(String regId) {
		this.regId = regId;
	}



	public BigDecimal getBalance() {
		return balance;
	}



	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}



	public LocalDateTime getCreateAt() {
		return createAt;
	}



	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}



	@Override
	public String toString() {
		return "Wallet [wallet_id=" + wallet_id + ", regId=" + regId + ", balance=" + balance + ", createAt=" + createAt
				+ "]";
	}



	
}


