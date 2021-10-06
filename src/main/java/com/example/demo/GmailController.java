package com.example.demo;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.services.EmailSenderService;

@RestController

public class GmailController {
	
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpSession session;

	@Autowired
	private EmailSenderService mailSender;
	
	
	@GetMapping("/sendMail/{toMail}")
	public String sendGmail(@PathVariable("toMail") String toMail)
	{
		try {
			int OTP=442266;
			session.setAttribute("OTP", OTP);
			
			
			mailSender.sendMimeMessageEmail(toMail,OTP);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Mail Sended";
	}
	
	
	@GetMapping("/verify/{otp}")
	public String verifyOTP(@PathVariable("otp") int otp) {
		int OTP=(int) session.getAttribute("OTP");
		
		
		String status="";
		if(OTP==otp) {
			status="OTP Verified";
		}
		else
		{
			status="Invalid OTP ";
		}
		return status;
	}
	
	
// send mail API added
	@GetMapping("/sendMails")
	public String sendMailsForMultiUsers() throws MessagingException {
		
		mailSender.simpleMailMessageForMultiples();
		return "Sended Multi Users";
	}
}
