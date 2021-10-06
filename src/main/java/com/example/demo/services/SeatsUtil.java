package com.example.demo.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Bus;
import com.example.demo.entities.UserRegistration;
import com.example.demo.entities.Wallet;
import com.example.demo.model.Balance;
import com.example.demo.model.BusResponse;
import com.example.demo.repo.UserRegistrationRepo;

@Service
public class SeatsUtil {
	
	@Autowired
	private UserRegistrationRepo userRepo;
	
	@Autowired
	private BusService busService;
	
	
	public List<BusResponse> displayAvaibleSeats(List<Bus> bus) {
		
		List<BusResponse> list=new ArrayList<BusResponse>();
		
		Iterator<Bus> i = bus.iterator();
		while(i.hasNext()) {
			
			Bus b=i.next();
			int bookingSeats = availableSeats(b.getFromroute(),b.getBusnumber());
			int availableSeats= 10-bookingSeats;
			System.out.println(availableSeats);
			
			
			list.add(new BusResponse(b.getBusnumber(), b.getBusname(), b.getSeatingcapacity(), b.getFromroute(), b.getToroute(), b.isSeat1(),  b.isSeat2(), b.isSeat3(),  b.isSeat4(),  b.isSeat5(),  b.isSeat6(),  b.isSeat7(),  b.isSeat8(),  b.isSeat9(),  b.isSeat10(),availableSeats ));
			
		}
		
		return list;
	}
	

	public int availableSeats(String fromRoute,int busnumber) {
		String str=busService.alreadyBookTicketsDisplay(fromRoute, busnumber);
		
		String s[]=str.split(",");
		
		int count=0;
		
		if(anyMatchSeat(s,"seat1")) {
			count+=1;
		}
		if(anyMatchSeat(s,"seat2")) {
			count+=1;
		}
		if(anyMatchSeat(s,"seat3")) {
			count+=1;
		}
		if(anyMatchSeat(s,"seat4")) {
			count+=1;
		}
		
		if(anyMatchSeat(s,"seat5")) {
			count+=1;
		}
		
		if(anyMatchSeat(s,"seat6")) {
			count+=1;
		}
		if(anyMatchSeat(s,"seat7")) {
			count+=1;
		}
		if(anyMatchSeat(s,"seat8")) {
			count+=1;
		}
		if(anyMatchSeat(s,"seat9")) {
			count+=1;
		}
		if(anyMatchSeat(s,"seat10")) {
			count+=1;
		}
		
		return count;
	}
	
	public boolean anyMatchSeat(String s[], String seatNo) {
		
		return Arrays.stream(s).anyMatch(str->str.equalsIgnoreCase(seatNo));
	}
	
	
	public Balance setBalance(String mobile,String balance) {
		
		UserRegistration reg =  userRepo.findByMobile(mobile);
		
		
		
		UserRegistration user=new UserRegistration();
		
		user.setAge(reg.getAge());
		user.setDob(reg.getDob());
		user.setEmail(reg.getEmail());
		user.setGender(reg.getGender());
		user.setLoginStatus(reg.getLoginstatus());
		user.setMobile(reg.getMobile());
		user.setName(reg.getName());
		user.setPassword(reg.getPassword());
		user.setRegDateTime(reg.getRegDateTime());
		user.setRegId(reg.getRegId());
		
		
		Wallet w=new Wallet();
		
		BigDecimal balance2 = reg.getWallet().getBalance();
		System.out.println("Existing Balance "+balance2);
		
		
		
		w.setBalance(new BigDecimal(balance));
		System.out.println(balance+ " Rs. Added to your account");
		w.setCreateAt(reg.getRegDateTime());
		w.setRegId(reg.getRegId());
		w.setWallet_id(reg.getWallet().getWallet_id());
		
		user.setWallet(w);
		
		userRepo.save(user);
		
		
		Balance b=new Balance();
		b.setBalance(user.getWallet().getBalance()+" added To Your Wallet ");
		return b;
	}
	
	
	 
	
}
