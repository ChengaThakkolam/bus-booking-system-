package com.example.demo.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Bus;
import com.example.demo.model.BookingResponseModel;
import com.example.demo.model.LoginResponse;
import com.example.demo.services.BusService;

@RestController
public class BusBookingController {

	private static final Logger log=LoggerFactory.getLogger(BusBookingController.class);

	@Autowired
	BusService busService;



	@PostMapping("/busbooking/{mobile}")
	public BookingResponseModel displaySeats(@RequestBody Bus bus,@PathVariable("mobile") String mobile) {

		log.debug("FID=BOOKING_CONTROLL ERROR=0 TEXT=REQUEST_BEGAN MOBILE={} BUS={}",mobile,bus);

		System.out.println("Booking Controller "+bus);

		

		System.out.println("Booking controller "+mobile);


		BookingResponseModel bookingResponseModel = busService.updateBusBooking(bus,mobile);

		log.debug("FID=BOOKING_CONTROLL  ERROR=0 TEXT=RESPONSE_SENT BOOKINGRESPONSE={}",bookingResponseModel);
		return  bookingResponseModel;
	}

}
