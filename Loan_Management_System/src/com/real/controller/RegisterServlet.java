package com.real.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.real.dao.RegisterDao;
import com.real.dao.RegisterDaoImpl;
import com.real.model.Register;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(RegisterServlet.class);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String contact=req.getParameter("contact");
		String pannumber=req.getParameter("pannumber");
		String aadharnumber=req.getParameter("aadharnumber");
		String typeloan=req.getParameter("typeloan");
		Register r=new Register();
		r.setName(name);
		r.setEmail(email);
		r.setContact(contact);
		r.setPannumber(pannumber);
		r.setAadharnumber(aadharnumber);
		r.setTypeloan(typeloan);
	    
		LOGGER.info("This is used to register the user");
		RegisterDao register=new RegisterDaoImpl();
		register.insert(r);
		
		resp.sendRedirect("Redirect.html");
		
		//int status=RegisterDao.save(r);
		
		/* if(status>0)
	       {
	       
	    	     //out.println("<p> Record Saved Successfully</p>");
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
			 
			 resp.sendRedirect("Redirect.html");
	       }  
	       else
	       {
	    	   resp.sendRedirect("error.jsp");
	       }*/
	}
	
	

}
