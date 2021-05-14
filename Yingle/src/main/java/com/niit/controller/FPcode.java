package com.niit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FPcode
 */
public class FPcode extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		 String femail=req.getParameter("email");       
	        try {
	            ResultSet rs=null;
	            ResultSet rs1=null;
	            DataBase db=new DataBase();
	            Connection con=DataBase.initalizedb();
	            Statement st=con.createStatement();
	            String query="select * from signup where email='"+femail+"' ";
	            rs=st.executeQuery(query);
	            if(rs.next())
	            {
	                final String username = "gauri.aman0@gmail.com";
	                final String password = "fclwgfokutilotnz";
	                
	                
	                Properties props = new Properties();
	                props.put("mail.smtp.starttls.enable", "true");
	                props.put("mail.smtp.auth", "true");
	                props.put("mail.smtp.host", "smtp.gmail.com");
	                props.put("mail.smtp.port", "587");
	                
	                Session session1 = Session.getInstance(props, new javax.mail.Authenticator() {
	                    @Override
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });
	                
	                try {
	                    String var=db.insert();
	                    String query1="update signup set code='"+var+"' where email='"+femail+"' ";
	                    rs1=st.executeQuery(query1);
	                    Message message = new MimeMessage(session1);
	                    message.setFrom(new InternetAddress("gauri.aman0@gmail.com"));
	                    message.setRecipients(Message.RecipientType.TO,
	                            InternetAddress.parse(femail));
	                    message.setSubject("Mingle Verification Code ");
	                    
	                    message.setText("Dear '"+femail+"' Please enter the code to reset your password,   '"+var+"'    "
	                            + "\n\n This is system generated email, Please do not reply to this email address");
	                    
	                    
	                    Transport.send(message);
	                    
	                    System.out.println("Done");
	                    
	                } catch (Exception e) {
	                    System.out.println(e);
	                }
	                resp.sendRedirect("ForgotPassword.jsp");
	             
	                HttpSession hs=req.getSession();
	                hs.setAttribute("email", femail);
	            }
	            
	            else
	            {
	                resp.sendRedirect("error.jsp");
	            }
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(FPcode.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (SQLException ex) {
	            Logger.getLogger(FPcode.class.getName()).log(Level.SEVERE, null, ex);
	        }
	         
	      
	    }
	    
	}


