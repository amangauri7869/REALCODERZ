package com.real.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.real.database.DbUtility;

/**
 * Servlet implementation class Code
 */
@WebServlet("/Code")
public class Code extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(Code.class);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		LOGGER.info("inside of doPost method of Code class ");
		String code=req.getParameter("code");
		//System.out.println(code);
		
		try {
			LOGGER.info("connection to database has been established");
			Connection con=DbUtility.getConnection();
			Statement st=con.createStatement();
			
			String query="select * from company where code='"+code+"' ";
			ResultSet rs=st.executeQuery(query);
			if(rs.next())
			{
				//System.out.println("enter new password");
				LOGGER.info("if the forgot password code matches with the database it redirects you to NewPassword.html");
				resp.sendRedirect("NewPassword.html");
			}
			else
			{
				//System.out.println("get lost");
				resp.sendRedirect("error.jsp");
			}
			
		}catch(Exception ex)
		{
			
			System.out.println("aman");
		}
		
	}
	
	

}
