package com.example.demo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Bus;
import com.example.demo.model.BusResponse;
import com.example.demo.model.BusSearchModel;
import com.example.demo.services.BusService;
import com.example.demo.services.SeatsUtil;

@RestController
public class SearchBusesController {
	
	private static final Logger log=LoggerFactory.getLogger(SearchBusesController.class);

	@Autowired
	BusService busService;
	
	@Autowired
	private SeatsUtil seat;
	
	
	@PostMapping("/searchbuses")
	public List<BusResponse> getBusesFromAndTo(@RequestBody BusSearchModel model){
		log.debug("FID=SEARCH_BUSES ERROR=0 TEXT=REQUEST_BEGAN BUS_SEARCH_MODEL={}",model);
		
		List<Bus> busesFromAndTo = busService.getBusesFromAndTo(model.getFrom(), model.getTo());
		
		System.out.println(busesFromAndTo);
		
		
		List<BusResponse> displayAvaibleSeats = seat.displayAvaibleSeats(busesFromAndTo);
		
		System.out.println("Search Buses Controller "+displayAvaibleSeats);
		
		log.debug("FID=SEARCH_BUSES ERROR=0 TEXT=RESPONSE_SENT_USER BUS_RESPONSE={}",displayAvaibleSeats);
		
		return displayAvaibleSeats;
	}
	

}
