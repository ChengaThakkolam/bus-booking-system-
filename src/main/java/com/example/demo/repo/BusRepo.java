package com.example.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Bus;

@Repository
public interface BusRepo extends CrudRepository<Bus, Integer> {
	
	
	public List<Bus> findByFromrouteAndToroute(String fromRoute,String toRoute);
	
	public Bus findByBusnumber(int busnumber);
	
	public Bus findByFromrouteAndBusnumber(String fromRoute,int busnumber);

}
