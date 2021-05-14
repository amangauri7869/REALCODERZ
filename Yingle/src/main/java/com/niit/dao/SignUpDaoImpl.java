package com.niit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.niit.model.SignUp;

public class SignUpDaoImpl implements SignUpDao {

	@Override
	public boolean insert(SignUp signup) {
		 try{
		       Class.forName("oracle.jdbc.driver.OracleDriver");
		       Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM" , "sql@2012");
		             PreparedStatement ps=con.prepareStatement("insert into signup(username, email, password) values(?,?,?)");
		             ps.setString(1, signup.getUsername());
		             ps.setString(2, signup.getEmail());
		             ps.setString(3, signup.getPassword());
		             
		           int i=ps.executeUpdate();
		           
		             System.out.println(i);
		          

		                 
		             System.out.println(signup.getUsername());
		             System.out.println(signup.getEmail());
		             System.out.println(signup.getPassword());
		             
		             if(i>0)
		             {
		               //  System.out.println("email code here");
		                 
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
		                    
		                    
		                    
		                    Message message = new MimeMessage(session1);
		                    message.setFrom(new InternetAddress("gauri.aman0@gmail.com"));
		                    message.setRecipients(Message.RecipientType.TO,
		                            InternetAddress.parse(signup.getEmail()));
		                    message.setSubject("Mingle Verification Code ");
		                    
		                    message.setText("Dear, '"+signup.getUsername()+"'"
		                    		+ " At the end of the day, I just want to sit with someone I love and chat about what matters and even what doesn’t.      "
		                            + "\n\n This is system generated email, Please do not reply to this email address");
		                    
		                    
		                    Transport.send(message);
		                    
		                    System.out.println("Done");
		                    
		                } catch (Exception e) {
		                    System.out.println(e);
		                }
		             
		             }
		             else
		             {
		                 //System.out.println("not email");
		                 
		               
		              
		             }
		             
		             
		        
		         
		         
		    }
		         catch(Exception e)
		         {
		         System.out.println(e);
		         }
		
		
		return false;
	}

}
