package com.example.demo.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.demo.model.BookingResponseModel;

@Component
public class FileOperationUtil {
	
	
	
	
	public void writeFile(BookingResponseModel bookingResponse ) {
		
		try {
			FileOutputStream fos=new FileOutputStream("e:/bus/"+bookingResponse.getName()+".pdf");
			System.out.println("start the file for generate invoice ");
			
			String name=bookingResponse.getName();
			String userRegId=bookingResponse.getRegId();
			String mobile=bookingResponse.getMobile();
			String SeatsNumbers=bookingResponse.getSeatNumber();
			String fromCity=bookingResponse.getFromCity();
			String toCity=bookingResponse.getToCity();
			float price=bookingResponse.getPrice();
			
			String bookingCreationTime=bookingResponse.getCreateAt();
			
			String uuid=UUID.randomUUID().toString();
			
			String bookingId=uuid;  // booking id 
			
			String title="Bus Booking Invoice Details";
			
			String body="UserName "+name+"\n UserId "+userRegId+"\n MobileNumber "+mobile+"\n SeatsNumbers"+SeatsNumbers+"\n FromCity "+fromCity+"\n ToCity "+toCity+"\n Price "+price;
			
			String fileContent=title+"\n "+body;
			
			byte b[]=fileContent.getBytes();
			
			fos.write(b);
			
			fos.close();
			
			System.out.println("file is closed ");
			
			
			
			
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
