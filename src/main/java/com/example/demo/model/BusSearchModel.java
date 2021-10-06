package com.example.demo.model;

public class BusSearchModel {
	
	private String from;
	
	private String to;
	
	public BusSearchModel() {
		// TODO Auto-generated constructor stub
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "BusSearchModel [from=" + from + ", to=" + to + "]";
	}
	
	
	

}
