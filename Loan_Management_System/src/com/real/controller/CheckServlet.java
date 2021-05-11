package com.real.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.real.dao.CompanyDao;
import com.real.model.Loans;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(CheckServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		LOGGER.info("inside of doGet method of CheckServlet");
		PrintWriter out=resp.getWriter();
		
		LOGGER.info("user session has been created");
		HttpSession hs=req.getSession();
		
	  	String name=(String)hs.getAttribute("user_name");
			String companyid=(String) hs.getAttribute("companyid");
	        System.out.println(name);
	        System.out.println(companyid);
	        hs.removeAttribute("user_name");
	        if(name==null)
	        {
	        	resp.sendRedirect("index.html");
	        }
		
	        List<Loans> list=CompanyDao.getStatus();
	        
	        out.println("<!DOCTYPE html>\r\n" + 
		     		"<html lang=\"en-US\">\r\n" + 
		     		"<head>\r\n" + 
		     		"<meta charset=\"UTF-8\" />\r\n" + 
		     		"<title>Loan management System</title>\r\n" + 
		     		"<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n" + 
		     		"</head>\r\n" + 
		     		"\r\n" + 
		     		"<body>\r\n" + 
		     		"<div id=\"wrap\">\r\n" + 
		     		"\r\n" + 
		     		"<nav id=\"mainnav\">\r\n" + 
		     		"\r\n" + 
		     		"<h1 id=\"textlogo\">\r\n" + 
		     		"Loans</span>\r\n" + 
		     		"</h1>\r\n" + 
		     		"<ul>\r\n" + 
		     		"\r\n" + 
		     		"	<li><a href=\"index.html\">Sign out</a></li>\r\n" + 
		     		"    \r\n" + 
		     		"\r\n" + 
		     		"\r\n" + 
		     		"</ul>\r\n" + 
		     		"</nav>");
		     
		     out.println("<h1>Users List</h1>"); 
		     LOGGER.info("users who have applied for laon their list have been shown in the form of table");
		     out.print("<table border='1' width='100%'");  
		     out.print("<tr><th>id</th><th>Company id</th><th>Status</th></tr>");
		     for(Loans l:list) {
		    	// System.out.println(l.getId());
		    	 //System.out.println(l.getCompanyid());
		    	 //System.out.println(l.getStatus());
		    out.print("<tr><td>"+l.getId()+"</td>"+l.getCompanyid()+"<td></td>"+l.getStatus()+"<td></td></tr>");
		     }
		     out.print("</table>");
		//out.println("HELO");
		
	}
	
	

}
