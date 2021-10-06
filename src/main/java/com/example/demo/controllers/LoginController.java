package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Login;
import com.example.demo.model.LoginResponse;
import com.example.demo.services.BusService;


@RestController
public class LoginController {
	
	@Autowired
	BusService busService;

	@PostMapping("login")
	public LoginResponse logincheck(@RequestBody Login login)
	{
		System.out.println("Login controlller "+login);
		
		boolean loginCheck = busService.loginCheck(login);
	
		System.out.println(loginCheck+" from login controll ");

		LoginResponse res=new LoginResponse();
		
		if(loginCheck==true) {
			    
	        res=new LoginResponse();
	        
	        res.setMessage(true);
	        res.setMobile(login.getMobile());
	        
		}
		
		return res;
	}
	
	

}
