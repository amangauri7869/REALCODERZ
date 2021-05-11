package com.real.logger;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class Test4jlogger
 */
@WebServlet("/Test4jlogger")
public class Test4jlogger extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(Test4jlogger.class); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		LOGGER.info("This is looging statement from log4j");
		
		
		String html = "<html><h2>Log4j has been initialized successfully!</h2></html>";
		response.getWriter().println(html);
	}
	
}
