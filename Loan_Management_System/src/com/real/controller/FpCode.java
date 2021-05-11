package com.real.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javax.servlet.http.HttpSession;

import com.real.dao.CompanyDao;
import com.real.database.DbUtility;

/**
 * Servlet implementation class FpCode
 */
@WebServlet("/FpCode")
public class FpCode extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String email=req.getParameter("email");
		
		CompanyDao cd=new CompanyDao();
	
		
		try {
			ResultSet rs=null;
			int rs1=0;
			Connection con=DbUtility.getConnection();
			Statement st=con.createStatement();
			String query="select * from company where companyemail='"+email+"' ";
			rs=st.executeQuery(query);
			if(rs.next())
			{
				 String host="smtp.gmail.com";  
				  final String user="gauri.aman0@gmail.com";  
				  final String password="obuvcevkcynljfqa";  
				    
				  String to=email; 
				  
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
				      String var=cd.insert();
				      String query1="update company set code='"+var+"' where companyemail='"+email+"' ";
				      rs1=st.executeUpdate(query1);
				     MimeMessage message = new MimeMessage(session);  
				     message.setFrom(new InternetAddress(user));  
				     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
				     message.setSubject("Financial Advisors");  
				     message.setText("Dear '"+email+"' Please enter the code '"+var+"'  to update your password "
				     		+ "\n\n This is an auto generated email, please do not reply to this email address");  
				       
				    //send the message  
				     Transport.send(message);  
				  
				     System.out.println("message sent successfully...");  
				   
				     } catch (MessagingException e) {e.printStackTrace();}
				    
				    HttpSession hs=req.getSession();
					hs.setAttribute("email", email);
				resp.sendRedirect("ForgotPassword.html");
				
				
			}
			else
			{
				resp.sendRedirect("error.jsp");
			}
			
			
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	
	
	
	
	
	
	
	
	
	}
	
	

}
