package com.example.demo.model;

public class Balance {

	private String balance;
	
	
	
	public Balance() {
		// TODO Auto-generated constructor stub
	}



	public String getBalance() {
		return balance;
	}



	public void setBalance(String balance) {
		this.balance = balance;
	}



	public Balance(String balance) {
		super();
		this.balance = balance;
	}



	@Override
	public String toString() {
		return "Balance [balance=" + balance + "]";
	}
	
	
}
