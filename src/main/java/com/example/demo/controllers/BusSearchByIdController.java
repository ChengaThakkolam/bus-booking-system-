package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Bus;
import com.example.demo.services.BusService;

@RestController
public class BusSearchByIdController {
	
	@Autowired
	BusService busService;
	
	@GetMapping("/booking/{busnumber}")	
	public Bus displayBusById(@PathVariable("busnumber") int busnumber) {
			
		Bus bus = busService.getBusById(busnumber);	
		
		System.out.println(bus);
		return bus;
	}
	
}
