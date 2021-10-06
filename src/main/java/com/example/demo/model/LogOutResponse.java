package com.example.demo.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogOutResponse {
	
	Logger logger=LoggerFactory.getLogger(this.getClass().getName());
	
	private boolean status;

	public boolean isStatus() {
		logger.debug("To Get Login Status "+status);
		
		return status;
	}

	public void setStatus(boolean status) {
		logger.debug("To Set Login Status "+status);
		this.status = status;
	}
	
	

}
