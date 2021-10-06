package com.example.demo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.BookingHistory;

import com.example.demo.services.BusService;

@RestController
public class BusBookingHistory {

	private static final Logger log=LoggerFactory.getLogger(BusBookingHistory.class);
	
	@Autowired
	BusService busService;
	
	@GetMapping("/bookinghistory/{mobile}")
	public List<BookingHistory> getBookingHistory(@PathVariable("mobile") String mobile) {
		
		log.debug("FID=BOOKING_HISTORY ERROR=0 TEXT=REQUEST_BEGIN MOBILE={}",mobile);
		
		System.out.println("BookingHistory controller mobile "+mobile);
		
		 List<BookingHistory> bookingHistory = busService.getBookingHistory(mobile);
		 
		log.debug("FID=BOOKING_HISTORY ERROR=0 TEXT=RESPONSE_SENT MOBILE={} BOOKINGHISTORY={}",mobile,bookingHistory);
		
	return bookingHistory;
	}
	
	
}


