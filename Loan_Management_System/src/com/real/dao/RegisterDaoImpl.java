package com.real.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.real.controller.RegisterServlet;
import com.real.database.DbUtility;
import com.real.model.Register;

public class RegisterDaoImpl implements RegisterDao{
	
	static final Logger LOGGER = Logger.getLogger(RegisterDaoImpl.class);
	@Override
	public boolean insert(Register r) {
	
		LOGGER.info("This is the insert method of users who will register");
		
		try {
			Connection con=DbUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into register(name, email, contact, pannumber, aadharnumber,typeloan) values(?,?,?,?,?,?)");
			ps.setString(1,r.getName());
			ps.setString(2,r.getEmail());
			ps.setString(3,r.getContact());
			ps.setString(4,r.getPannumber());
			ps.setString(5,r.getAadharnumber());
		    ps.setString(6,r.getTypeloan());	
			int roll=ps.executeUpdate();
			
			if(roll>0)
			{
				LOGGER.info("If the data is saved successfully the use will receive email on his/her given id");
				//System.out.println("email code ");
				 String host="smtp.gmail.com";  
				  final String user="gauri.aman0@gmail.com";  
				  final String password="obuvcevkcynljfqa";  
				    
				  String to=r.getEmail(); 
				  
				   //Get the session object  
				   Properties props = new Properties(); 
				   props.put("mail.smtp.starttls.enable", "true");
				   props.put("mail.smtp.host",host);  
				   props.put("mail.smtp.auth", "true");  
				   props.put("mail.smtp.port", "587");  
				   Session session = Session.getDefaultInstance(props,  
				    new javax.mail.Authenticator() {  
				      protected PasswordAuthentication getPasswordAuthentication() {  
				    return new PasswordAuthentication(user,password);  
				      }  
				    });  
				  
				   //Compose the message  
				    try {  
				     MimeMessage message = new MimeMessage(session);  
				     message.setFrom(new InternetAddress(user));  
				     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
				     message.setSubject("Financial Advisors");  
				     message.setText("Dear '"+r.getName()+"'  Thanking for Registering with us. Our maximum response time is 24 hours "
				     		+ "\n\n This is an auto generated email, please do not reply to this email address");  
				       
				    //send the message  
				     Transport.send(message);  
				  
				     System.out.println("message sent successfully...");  
				   
				     } catch (MessagingException e) {e.printStackTrace();}
				
			}
			else
			{
				
				System.out.println("no");
			}
		}catch(Exception ex) { }
		
		
		return false;
	
		
	}

	
	
	
	
	/*public static int save(Register r) {

		int roll=0;
		try {
			Connection con=DbUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into register(name, email, contact, pannumber, aadharnumber,typeloan) values(?,?,?,?,?,?)");
			ps.setString(1,r.getName());
			ps.setString(2,r.getEmail());
			ps.setString(3,r.getContact());
			ps.setString(4,r.getPannumber());
			ps.setString(5,r.getAadharnumber());
		    ps.setString(6,r.getTypeloan());	
			roll=ps.executeUpdate();
			
		}catch(Exception ex) { }
		
		
		return roll;
		
	}*/

	
	
	
	
/*	public static int save(Register r)
	{
		int roll=0;
		try {
			Connection con=DbUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into register(name, email, contact, pannumber, aadharnumber,typeloan) values(?,?,?,?,?,?)");
			ps.setString(1,r.getName());
			ps.setString(2,r.getEmail());
			ps.setString(3,r.getContact());
			ps.setString(4,r.getPannumber());
			ps.setString(5,r.getAadharnumber());
		    ps.setString(6,r.getTypeloan());	
			roll=ps.executeUpdate();
			
		}catch(Exception ex) { }
		
		
		return roll;
		
	}*/
	
	public static int approve(String id, String companyid)
	{
		int roll=0;
		try {
			
			Connection con=DbUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into loans(id,companyid,status) values(?,?,?)");
			ps.setString(1, id);
			ps.setString(2, companyid);
			ps.setBoolean(3, true);
			roll=ps.executeUpdate();
			
		}catch(Exception e) {System.out.println(e);}
		
		
		
		
		
		return roll;
	}





	
	
	

}
