package com.real.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.real.database.DbUtility;

/**
 * Servlet implementation class CheckPassword
 */
@WebServlet("/CheckPassword")
public class CheckPassword extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(CheckPassword.class); 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		LOGGER.info("you are inside of do post method of check password class");
		PrintWriter out=resp.getWriter();
		
		String pass1=req.getParameter("pass1");
		String pass2=req.getParameter("pass2");
		
		//System.out.println(pass1);
		//System.out.println(pass2);
		int rs=0;
		try {
			Connection con=DbUtility.getConnection();
			LOGGER.warn("connection has been established");
			Statement st=con.createStatement();
			
			if(pass1.equals(pass2))
			{
				//jdbc query to update password
				HttpSession session=req.getSession();
				String email=(String) session.getAttribute("email");
				String query="update company set companypassword='"+pass2+"' where companyemail='"+email+"' ";
				rs=st.executeUpdate(query);
				LOGGER.info("redirecting company to reset password page");
				resp.sendRedirect("ResetPass.html");
				//out.println("password updated successfully");
			}
			else
			{
				LOGGER.info("passwords are not matching");
				System.out.println("password do not match");
			}
			
		}catch(Exception ex)
		{
			
			System.out.println(ex);
		}
		
	}
	
	

}
