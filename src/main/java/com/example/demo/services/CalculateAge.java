package com.example.demo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.stereotype.Service;


@Service
public class CalculateAge {
	
	
	public int calculateAgeBasedOnDOB(String dob) throws ParseException {
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 Date date;
		
			date = formatter.parse(dob);
			//Converting obtained Date object to LocalDate object
		      Instant instant = date.toInstant();
		      ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
		      LocalDate givenDate = zone.toLocalDate();
		      
		    //Calculating the difference between given date to current date.
		      Period period = Period.between(givenDate, LocalDate.now());
		      System.out.println(period.getYears());
		     return period.getYears();
		
	}

}
