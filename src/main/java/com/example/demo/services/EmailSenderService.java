package com.example.demo.services;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendSimpleEmail(String toEmail,String body,String subject,String fromEmail) {
			
		 SimpleMailMessage message=new SimpleMailMessage();
		 
		 message.setFrom(fromEmail);
		 message.setTo(toEmail);
		 message.setText("<html><body><img src='https://images.unsplash.com/photo-1532012197267-da84d127e765?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=334&q=80'></body></html>");
		 message.setSubject(subject);
		 
		 mailSender.send(message);
		 
		 System.out.println("Mail Sended.... ");
		 
	}
	
	public void sendMimeMessageEmail(String toEmail,int OTP) throws MessagingException {
		
	
		
		 
		 MimeMessage mimeMessage=mailSender.createMimeMessage();
		 
		 MimeMessageHelper helper=new MimeMessageHelper(mimeMessage, true);
		 
		 helper.setFrom("chengachandu@gmail.com");
		 helper.setTo(toEmail);
		 helper.setText("<html><body><h1>This Contains body and Image</h1> <p>OTP "+OTP+"</p><img src='https://images.unsplash.com/photo-1532012197267-da84d127e765?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=334&q=80'></body></html>",true);
		 helper.setSubject("This is the Subject");
		 
		 FileSystemResource file=new FileSystemResource(new File("E:\\ITextTest.pdf"));
		 
		 helper.addAttachment("Invoice.pdf", file);
		 
		 mailSender.send(mimeMessage);
		 
		 
		 System.out.println(" Invoice Mail Sended.... ");
		 
	}
	
	public void simpleMailMessageForMultiples() throws MessagingException {
		
		String email[]=new String[4];
		email[0]="tchenga6073@gmail.com";
		email[1]="chengachandu@gmail.com";
		email[2]="chenga9491@gmail.com";
		email[3]="chengareddy9700@gmail.com";
		
		
		
		
		MimeMessage mimeMessage=mailSender.createMimeMessage();
		
		MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
		
		helper.setTo(email);
		helper.setFrom("chengachandu@gmail.com");
		helper.setText("<html><body><h3>This is The Heading Of the Gmail</h3><img src='https://images.unsplash.com/photo-1544947950-fa07a98d237f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8OHx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=60'></body></html>", true);
		helper.setSubject("this is Multi user");
		helper.setSentDate(new Date());
		
		mailSender.send(mimeMessage);
		
		System.out.println("Send Gamil For Multi Users ");

	}
}
