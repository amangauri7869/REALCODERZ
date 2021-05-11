package com.real.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.real.exception.MyException;
import com.real.logger.Test4jlogger;

import org.apache.log4j.Logger;
/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(AdminServlet.class); 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
		LOGGER.info("Inside do post of admin servlet class");
	    PrintWriter out=resp.getWriter();
		String id=req.getParameter("id");
		String password=req.getParameter("password");
		try {
		if(id.equals("aman") && password.equals("gauri") )
		{
			LOGGER.info("redirecting to view servlet");
			resp.sendRedirect("ViewServlet");
			
		}
		
		
		
		else
		{
			resp.sendRedirect("error.jsp");
			out.println("szssssssssssssssss");
			LOGGER.error("Exception has occured");
			throw new MyException("please enter given login details");	
		}
		
		}
		catch(Exception e) { System.out.println("please enter given login details"); }
		
	     
	}
	
	

}
