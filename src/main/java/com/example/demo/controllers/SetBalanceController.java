package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Balance;
import com.example.demo.services.SeatsUtil;

@RestController
public class SetBalanceController {

	@Autowired
	private SeatsUtil seatUtil;
	
	@PostMapping("setbalance/{mobile}")
	public Balance addBalance(@PathVariable("mobile") String mobile,@RequestBody Balance balance) {
			
		System.out.println(balance);
		
		Balance setBalance = seatUtil.setBalance(mobile, balance.getBalance());
		
		return setBalance;
	}
}
