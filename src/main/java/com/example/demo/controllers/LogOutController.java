package com.example.demo.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LogOutResponse;
import com.example.demo.services.LogOutUtil;


@RestController
public class LogOutController {

	@Autowired
	private LogOutUtil o;
	
	private static final Logger logger=LoggerFactory.getLogger(LogOutController.class.getName());
	
	
	@GetMapping("logout/{mobile}")
	
	public LogOutResponse logOut(@PathVariable("mobile") String mobile)  {
		
		logger.debug("in this path User Mobile Number is "+mobile);
		
		System.out.println("logOut Controller mobile "+mobile);
		
		boolean status = o.logOutUtil(mobile);
	
		LogOutResponse logOutResponse=new LogOutResponse();
		logOutResponse.setStatus(status);
		
		logger.debug("to Send LogOutResponse to Client "+logOutResponse);
		
		return logOutResponse;
	}
}
