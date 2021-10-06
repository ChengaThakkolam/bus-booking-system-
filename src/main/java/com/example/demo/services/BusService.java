package com.example.demo.services;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.BookingHistory;
import com.example.demo.entities.Bus;

import com.example.demo.entities.UserRegistration;

import com.example.demo.model.BookingResponseModel;
import com.example.demo.model.Login;
import com.example.demo.repo.BookingHistoryRepo;
import com.example.demo.repo.BusRepo;
import com.example.demo.repo.UserRegistrationRepo;



@Service
public class BusService {
	
	private static final Logger log=LoggerFactory.getLogger(BusService.class);
	
	@Autowired
	private EmailSenderService emailService;
	
	@Autowired
	private BusRepo busRepo;
	
	@Autowired
	private UserRegistrationRepo userRepo;
	
	@Autowired
	private BookingHistoryRepo bookingHistoryRepo;
	
	@Autowired
	private LogOutUtil l;
	
	
	public Bus addBus(Bus bus) {
		
		log.debug("FID=ADD_BUS ERROR=0 TEXT=ADD_BUS_SAVING_BEGIN BUS={}",bus);
		
		Bus save = busRepo.save(bus);
		
		log.debug("FID=ADD_BUS ERROR=0 TEXT=ADD_BUS_RESPONSE BUS={}",save);
		
		return save;
	}
	
	
	public BookingResponseModel updateBusBooking(Bus bus,String mobile) {
		
		log.debug("FID=UPDATE_BUS_BOOKING ERROR=0 TEXT=UPDATE_REQUEST_PROCESS BUS={} MOBILE={}",bus,mobile);
		float price=0.0f;
		String seatNumber="";
		
		
		String alreadyBookTicketsDisplay = alreadyBookTicketsDisplay(bus.getFromroute(),bus.getBusnumber());
		
		String str[]=alreadyBookTicketsDisplay.split(",");
		
	
		if(bus.isSeat1()==true) {
			if(anyMatch(str, "seat1")){
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat1,";
			}
		}
		if(bus.isSeat2()==true) {
			
			if(anyMatch(str, "seat2")){  //if any match seat2 
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat2,";
			}
		}
		if(bus.isSeat3()==true) {
			if(anyMatch(str, "seat3")){  //if any match seat2 
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat3,";
			}
		}
		if(bus.isSeat4()==true) {
			if(anyMatch(str, "seat4")){  //if any match seat4 
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat4,";
			}
		}
		
		if(bus.isSeat5()==true) {
			if(anyMatch(str, "seat5")){  //if any match seat5 
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat5,";
			}
		}
		
		if(bus.isSeat6()==true) {
			if(anyMatch(str, "seat6")){  //if any match seat6 
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat6,";
			}
		}
		
		if(bus.isSeat7()==true) {
			if(anyMatch(str, "seat7")){  //if any match seat7 
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat7,";
			}	
		}
		
		if(bus.isSeat8()==true) {
			if(anyMatch(str, "seat8")){  //if any match seat8 
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat8,";
			}
		}
		
		if(bus.isSeat9()==true) {
			if(anyMatch(str, "seat9")){  //if any match seat9 
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat9,";
			}
		}
		
		if(bus.isSeat10()==true) {
			if(anyMatch(str, "seat10")){  //if any match seat10 
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat10";
			}
		}
		
	
		// check login Status 
		
		boolean loginStatus = l.checkLoginStatus(mobile);
		// check price based on user wallet amount
		
		boolean checkBalance = l.checkBalance(mobile,new BigDecimal(price));
		
		
		// get User Details based on mobile
		UserRegistration user = l.getUser(mobile);
		
		BookingResponseModel bookingModel=new BookingResponseModel();
		if(loginStatus==true && checkBalance==true) {
			// update Bus for Booking
			
			
			
			Bus save2 = busRepo.save(bus);
			System.out.println(save2);
			
			
			String seatNumbers="Seat Number["+seatNumber+"]";
			LocalDateTime time=LocalDateTime.now();
			bookingModel=new BookingResponseModel(mobile,user.getName(),user.getRegId(),seatNumbers,price,time.toString(),bus.getFromroute(),bus.getToroute());
		
			
			
			BookingHistory history=new BookingHistory();
			history.setMobile(bookingModel.getMobile());
			history.setName(bookingModel.getName());
			history.setCreateAt(bookingModel.getCreateAt());
			history.setFromCity(bookingModel.getFromCity());
			history.setPrice(bookingModel.getPrice());
			history.setRegId(bookingModel.getRegId());
			history.setSeatNumber(bookingModel.getSeatNumber());
			history.setToCity(bookingModel.getToCity());
			
			
			
			
			BookingHistory bookingHistory = bookingHistoryRepo.save(history);
			
			
			// sending email to user for response of bus booking history and details 
			
			emailService.sendMimeMessageEmail(user.getEmail(), seatNumbers,bookingModel);
			
			log.debug("FID=UPDATE_BUS_BOOKING ERROR=0 TEXT=UPDATE_RESPONE_SENT BOOKINGHISTORY={} ",bookingHistory);
			
			
			
		}
		
			
		
		return bookingModel;
	}
	
	
	
	public List<Bus> getBuses(){
		
		log.debug("FID=GETBUSES ERROR=0 TEXT=GET_BUSES_PROCESS_BEGIN ");
		
		List<Bus> list1=(List<Bus>) busRepo.findAll();
		
		log.debug("FID=GETBUSES ERROR=0 TEXT=GET_BUSES_RESPONSE BUSES={}",list1);
		
		return list1;
		
	}
	
	@Transactional
	public List<Bus> getBusesFromAndTo(String from,String to){
		log.debug("FID=GET_BUSES_FROMROUTE_AND_TOROUTE ERROR=0 TEXT=GET_BUSES_FROMROUTE_AND_TOROUTE_PROCESS_BEGIN FROMROUTE_IS={} TOROUTE_IS={} ",from,to);
		
		List<Bus> list1=busRepo.findByFromrouteAndToroute(from, to);
		
		log.debug("FID=GET_BUSES ERROR=0 TEXT=GET_BUSES_FROMROUTE_AND_TOROUTE_PROCESS_RESPONSE_SENT_TO_CONTROLLER BUSES={}  ",list1);
		return list1;
	}
	
	@Transactional
	public boolean loginCheck(Login login) {
		
		log.debug("FID=LOGIN_CHECK ERROR=0 TEXT=LOGIN_CHECK_PROCESS_BEGIN LOGIN={}  ",login);
		UserRegistration userRegistration = userRepo.findByMobileAndPassword(login.getMobile(), login.getPassword());
		
		
		
		if(userRegistration.getMobile().equalsIgnoreCase(login.getMobile()) &&  userRegistration.getPassword().equalsIgnoreCase(login.getPassword()) )
		{
			log.debug("FID=LOGIN_CHECK ERROR=0 TEXT=USER_IS_EXITED LOGIN={}  ",login);
			
			UserRegistration user=userRegistration;
			System.out.println("change login status "+user);
			
			user.setLoginStatus(true);
			
			UserRegistration save = userRepo.save(user);
			
			log.debug("FID=LOGIN_CHECK ERROR=0 TEXT=LOGIN_STATUS_CHANGE LOGIN_STATUS={}  ",save.getLoginstatus());
			
			return true;
			
		}
		else
		{
			log.debug("FID=LOGIN_CHECK ERROR=0 TEXT=USER_IS_NOT_EXISTED LOGIN_STATUS={}  ",false);
			return false;
		}
	}
	
	@Transactional
	public String alreadyBookTicketsDisplay(String fromRoute,int busnumber) {
		
		log.debug("FID=ALREADY_BOOK_TICKETS_DISPLAY ERROR=0 TEXT=DISPLAY_BOOKING_TICKETS_PROCESS FROM_ROUTE={} BUS_NUMBER={} ",fromRoute,busnumber);
		
		Bus bus = busRepo.findByBusnumber(busnumber);
		
		String seats="";
		
		
		if(bus.isSeat1()==true) {
			seats+="seat1,";
		}
		if(bus.isSeat2()==true) {
			seats+="seat2,";
		}
		if(bus.isSeat3()==true) {
			seats+="seat3,";
		}
		
		if(bus.isSeat4()==true) {
			seats+="seat4,";
		}
		if(bus.isSeat5()==true) {
			seats+="seat5,";
		}
		if(bus.isSeat6()==true) {
			seats+="seat6,";
		}
		if(bus.isSeat7()==true) {
			seats+="seat7,";
		}
		if(bus.isSeat8()==true) {
			seats+="seat8,";
		}
		if(bus.isSeat9()==true) {
			seats+="seat9,";
		}
		if(bus.isSeat10()==true) {
			seats+="seat10";
		}
		
		System.out.println("Already Booking Seats "+seats);
		
		log.debug("FID=ALREADY_BOOK_TICKETS_DISPLAY ERROR=0 TEXT=DISPLAY_BOOKING_TICKETS_EXECUTED FROM_ROUTE={} BUS_NUMBER={} ALREADY_BOOKING_TICKETS={} ",fromRoute,busnumber,seats);
		
		return seats;
	}


	
	public boolean anyMatch(String s[], String seatNo) {
		
		return Arrays.stream(s).anyMatch(str->str.equalsIgnoreCase(seatNo));
	}
	
	public Bus getBusById(int busnumber) {
		
		log.debug("FID=GET_BUS_BY_ID ERROR=0 TEXT=GET_BUS_BY_ID_PROCESS BUS_NUMBER={} ",busnumber);
		
		Bus bus = busRepo.findByBusnumber(busnumber);
		
		log.debug("FID=GET_BUS_BY_ID ERROR=0 TEXT=GET_BUS_BY_ID_EXECUTED BUSES={} BUS_NUMBER={} ",bus,busnumber);
		
		return bus;
		
	}
	
	public List<BookingHistory> getBookingHistory(String mobile) {
		
		log.debug("FID=GET_BOOKING_HISTORY ERROR=0 TEXT=GET_BOOKING_HISTORY_PROCESS MOBILE={} ",mobile);
		
		List<BookingHistory> bookingHistory = bookingHistoryRepo.findByMobile(mobile);
		
		log.debug("FID=GET_BOOKING_HISTORY ERROR=0 TEXT=GET_BOOKING_HISTORY_EXECUTED BOOKING_HISTORY={}",bookingHistory);
		
		return bookingHistory;
		
	}
	
}
