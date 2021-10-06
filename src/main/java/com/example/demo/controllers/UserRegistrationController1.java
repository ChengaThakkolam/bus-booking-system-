package com.example.demo.controllers;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.UserRegistration;
import com.example.demo.entities.Wallet;
import com.example.demo.model.UserRegistrationRequest;
import com.example.demo.repo.UserRegistrationRepo;
import com.example.demo.services.CalculateAge;



@RestController
public class UserRegistrationController1 {
	
	private static final Logger log=LoggerFactory.getLogger(UserRegistrationController1.class);

	@Autowired
	private CalculateAge age;
	
	@Autowired
	private UserRegistrationRepo userRepo;
	
	
	@PostMapping("/userregistration")
	public UserRegistration hello(@RequestBody UserRegistrationRequest reg)  {
		
		log.debug("FID=USER_REGISTRATION ERROR=0 TEXT=REQUEST_BEGIN USER_REGISTRATION_REQUEST={}",reg);
		
		UserRegistration userReg=new UserRegistration();
		
		
		UUID regid=UUID.randomUUID();
		LocalDateTime t=LocalDateTime.now();
		
		
		
		userReg.setDob(reg.getDob());
		
		
		try {
			int currentAge = age.calculateAgeBasedOnDOB(reg.getDob());
			userReg.setAge(currentAge);
			
			log.debug("FID=USER_REGISTRATION ERROR=0 TEXT=CALCULATE_AGE_BASED_ON_DOB DOB={} AGE={} USER_REGISTRATION_REQUEST={}",reg.getDob(),age,reg);
		} catch (ParseException e) {
			log.debug("FID=USER_REGISTRATION ERROR=0 TEXT=CALCULATE_AGE_BASED_ON_DOB_FAILED_BECAUSE_DOB_IS_NOT_CORRECT_FORMATE DOB={} AGE={} USER_REGISTRATION_REQUEST={}",reg.getDob(),age,reg);
			e.printStackTrace();
		}
		
		
		
		userReg.setEmail(reg.getEmail());
		userReg.setGender(reg.getGender());
		userReg.setMobile(reg.getMobile());
		userReg.setName(reg.getName());
		userReg.setPassword(reg.getPassword());
		userReg.setLoginStatus(false);
		
		
		Wallet w=new Wallet();
		w.setRegId(t.toString());
		w.setBalance(new BigDecimal(reg.getWallet()));  
		
		w.setCreateAt(t);
		
		userReg.setWallet(w);
		

		UserRegistration registration = userRepo.save(userReg);
		
		log.debug("FID=USER_REGISTRATION ERROR=0 TEXT=RESPONSE_SENT_USER USER_REGISTRATION={}",	registration);
		
		
		return registration;
		
	}
}
