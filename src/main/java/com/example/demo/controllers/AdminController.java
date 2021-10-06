package com.example.demo.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Bus;
import com.example.demo.services.BusService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger log=LoggerFactory.getLogger(AdminController.class);

	@Autowired
	BusService busService;
	
	@PostMapping("/addbus")
	public Bus addBus(@RequestBody Bus bus) {
		
		log.debug("FID=ADD_BUS ERROR=0 TEXT=REQUEST_BEGAN BUS={}",bus);
	
	 Bus addBus = busService.addBus(bus);
		
		log.debug("FID=ADD_BUS ERROR=0 TEXT=RESPONSE_SEND BUS={}",addBus);
		
		return addBus;
	}
}
