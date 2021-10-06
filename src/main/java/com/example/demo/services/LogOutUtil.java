package com.example.demo.services;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.UserRegistration;
import com.example.demo.repo.BookingHistoryRepo;
import com.example.demo.repo.BusRepo;
import com.example.demo.repo.UserRegistrationRepo;


@Service
public class LogOutUtil {
	
	
	
	@Autowired
	private BusRepo busRepo;
	
	@Autowired
	private BookingHistoryRepo bookingHistoryRepo;
	
	@Autowired
	private UserRegistrationRepo userRepo;
	
	Logger logger=LoggerFactory.getLogger(LogOutUtil.class.getName());
	
	
	public boolean logOutUtil(String mobile) {
		
		logger.debug("FID=LOGOUT_UTIL ERROR=0 TEXT=LOGOUT_UTIL_PROCESS_BEGIN MOBILE={}",mobile);
		
		 UserRegistration findByMobile = userRepo.findByMobile(mobile);
		
		if(findByMobile.getMobile().equals(mobile)) {
			
			findByMobile.setLoginStatus(false);
			
			UserRegistration save = userRepo.save(findByMobile);
			logger.debug("FID=LOGOUT_UTIL ERROR=0 TEXT=USER_MOBILE={}_IS_EXISTED_IN_DB_THEN_PROCEED_TO_LOGOUT USER_RGISTRAION={}",mobile,save);
			
			
			logger.debug("FID=LOGOUT_UTIL ERROR=0 TEXT=USER_MOBILE={}_IS_EXISTED_IN_DB_THEN_PROCEED_TO_LOGOUT ",mobile);
			logger.debug("FID=LOGOUT_UTIL ERROR=0 TEXT=USER_MOBILE={}_IS_EXISTED_IN_DB_THEN_PROCEED_TO_LOGOUT_CHANGE_LOGIN_STATUS_FALSE",mobile);
		}
		else
		{
			logger.debug("FID=LOGOUT_UTIL ERROR=0 TEXT=USER_MOBILE={}_IS_NOT_EXISTED_IN_DB_THEN_LOGOUT_PROCESS_FAIL",mobile);
			
		}
		
		if(findByMobile.getMobile().equals(mobile)) {
			return true;
		}
		else
		{
			return false;
		}
		
	}

	
	public boolean checkLoginStatus(String mobile) {
		logger.debug("FID=CHECK_LOGIN_STATUS ERROR=0 TEXT=CHECK_LOGIN_STATUS_PROCESS MOBILE={}",mobile);		
		
		UserRegistration registration = userRepo.findByMobile(mobile);
		
		logger.debug("FID=CHECK_LOGIN_STATUS ERROR=0 TEXT=CHECK_LOGIN_STATUS_EXECUTED MOBILE={} USEREGISTRATION={}",mobile,registration);
		
		return registration.getLoginstatus();
	}
	
	
	
	public boolean checkBalance(String mobile,BigDecimal seatPrice) {
		
		boolean b=false;
		logger.debug("FID=CHECK_BALANCE ERROR=0 TEXT=CHECK_BALANCE_PROCESS MOBILE={} SEATPRICE={}",mobile,seatPrice);
	
		UserRegistration registration = userRepo.findByMobile(mobile);
		
		logger.debug("FID=CHECK_BALANCE ERROR=0 TEXT=CHECK_BALANCE_PROCESS MOBILE={} SEATPRICE={} USERREGISTRATION={}",mobile,seatPrice,registration);
		
		if(seatPrice.floatValue() <= registration.getWallet().getBalance().floatValue()) {
			logger.debug("FID=CHECK_BALANCE ERROR=0 TEXT=CHECK_BALANCE_PROCESS MOBILE={} SEATPRICE={} USER_BALANCE={}",mobile,seatPrice, registration.getWallet().getBalance());
			logger.debug("FID=CHECK_BALANCE ERROR=0 TEXT=SUFFICIENT_BALANCE_IS_EXISTED ");
			
			return true;
		}
		else
		{
			logger.debug("FID=CHECK_BALANCE ERROR=0 TEXT=CHECK_BALANCE_PROCESS MOBILE={} SEATPRICE={} USER_BALANCE={}",mobile,seatPrice, registration.getWallet().getBalance());
			logger.debug("FID=CHECK_BALANCE ERROR=0 TEXT=SUFFICIENT_BALANCE_IS_NOT_EXISTED SEAT_PRICE={} BALANCE={} ",seatPrice, registration.getWallet().getBalance());
			
			return false;
			
		}
		
		
	}
	
	
	
	public UserRegistration getUser(String mobile) {
		logger.debug("FID=CHECK_REGISTRATION ERROR=0 TEXT=CHECK_REGISTRATION_PROCESS MOBILE={}",mobile);
		UserRegistration registration = userRepo.findByMobile(mobile);
		logger.debug("FID=CHECK_REGISTRATION ERROR=0 TEXT=CHECK_REGISTRATION_EXECUTED MOBILE={} USER_REGISTRATION={}",mobile,registration);		
		return registration;
	}

}
