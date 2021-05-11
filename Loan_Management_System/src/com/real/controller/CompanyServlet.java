package com.real.controller;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
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

import com.real.dao.AdminDao;
import com.real.dao.CompanyDao;
import com.real.database.DbUtility;
import com.real.model.Company;

/**
 * Servlet implementation class CompanyServlet
 */
@WebServlet("/CompanyServlet")
public class CompanyServlet extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(CompanyServlet.class);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		LOGGER.info("Inside of doPost method of CompanyServlet occurs at the time of registration");
		PrintWriter out =resp.getWriter();
		String companyname=req.getParameter("companyname");
		String companyaddress=req.getParameter("companyaddress");
		String companypan=req.getParameter("companypan");
		String companyaadhar=req.getParameter("companyaadhar");
		String companynumber=req.getParameter("companynumber");
		String companyemail=req.getParameter("companyemail");
		String companypassword=req.getParameter("companypassword");
		//int companyid=Integer.parseInt(req.getParameter("companyid"));
		
		Company c=new Company();
		//c.setCompanyid(companyid);
		c.setCompanyname(companyname);
		c.setCompanyaddress(companyaddress);
		c.setCompanypan(companypan);
		c.setCompanyaadhar(companyaadhar);
		c.setCompanynumber(companynumber);
		c.setCompanyemail(companyemail);
      	c.setCompanypassword(companypassword);	
      	LOGGER.info("calling the save function from company dao class to save the details");
		int status=CompanyDao.save(c);
		
		List<Company> list=CompanyDao.id();
		for(Company co:list) {
			
		if(status>0)
		{
			LOGGER.info("This is basically email code, first it will check whether the creditanls are saved and then send mail");
			///email code here
			 String host="smtp.gmail.com";  
			  final String user="gauri.aman0@gmail.com";  
			  final String password="obuvcevkcynljfqa";  
			    
			  String to=c.getCompanyemail(); 
			  
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
			     message.setSubject("Financial Company");
			     message.setText("Dear '"+c.getCompanyname()+"'  Thanking for Registering with us. your id is '"+co.getCompanyid()+"'  . please use this to login in our website. Our maximum response time is 24 hours "
			     		+ "\n\n This is an auto generated email, please do not reply to this email address");  
			    	       
			    //send the message  
			     Transport.send(message);  
			  
			     System.out.println("message sent successfully...");  
			   
			     } catch (MessagingException e) {e.printStackTrace();}  
LOGGER.info("Redirects you to confirmation page which congratulates you have registered");			 
			resp.sendRedirect("Redirect.html");
		}
		else
		{
			resp.sendRedirect("error.jsp");
			System.out.println("record is not saved");
		}
		
	}
	
		
		
		
	}
}
