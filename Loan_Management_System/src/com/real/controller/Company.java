package com.real.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.real.dao.AdminDao;
import com.real.dao.AdminDaoImpl;
import com.real.dao.CompanyDao;
import com.real.model.Loans;
import com.real.model.Register;

/**
 * Servlet implementation class Company
 */
@WebServlet("/Company")
public class Company extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(Company.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		LOGGER.info("inside of doGet method of company servlet");
		PrintWriter out=resp.getWriter();
		
		LOGGER.info("Session has been created");
		HttpSession hs=req.getSession();
		
  	String name=(String)hs.getAttribute("user_name");
		String companyid=(String) hs.getAttribute("companyid");
        System.out.println(name);
        System.out.println(companyid);
        hs.removeAttribute("user_name");
        if(name==null)
        {
        	resp.sendRedirect("index1.html");
        }
		
		//String companyid=(String) hs.getAttribute("companyid");
        
        AdminDao admin=new AdminDaoImpl();
        List<Register> list=admin.getAllUsers();
		//List<Register> list= AdminDao.getAllUsers();  
		List<Loans> list1=CompanyDao.getStatus();
//		Loans l=new Loans(); 
		com.real.model.Company c=new com.real.model.Company();
		
		 out.println("<!doctype html>\r\n" + 
		     		"\r\n" + 
		     		"<html lang=\"en-US\">\r\n" + 
		     		"<head>\r\n" + 
		     		"<meta charset=\"UTF-8\" />\r\n" + 
		     		"<title>Loan Management System</title>\r\n" + 
		     		"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n" + 
		     		"   <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n" + 
		     		"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n" + 
		     		"   <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n" + 
		     		"</head>\r\n" + 
		     		"\r\n" + 
		     		"<body>\r\n" + 
		     		"<div id=\"wrap\">\r\n" + 
		     		"\r\n" + 
		     		"<nav class=\"navbar navbar-inverse\" style=\"font-size: 20px\">\r\n" + 
		     		"  <div class=\"container-fluid\">\r\n" + 
		     		"    <div class=\"navbar-header\">\r\n" + 
		     		"      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\r\n" + 
		     		"        <span class=\"icon-bar\"></span>\r\n" + 
		     		"        <span class=\"icon-bar\"></span>\r\n" + 
		     		"        <span class=\"icon-bar\"></span>                        \r\n" + 
		     		"      </button>\r\n" + 
		     		"      <a class=\"navbar-brand\" href=\"index1.html\">Loans</a>\r\n" + 
		     		"    </div>\r\n" + 
		     		"    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\r\n" + 
		     		"      <ul class=\"nav navbar-nav\">\r\n" + 
		     		"        <li class=\"active\"><a href=\"index1.html\">Home</a></li>\r\n" + 
		     		"        \r\n" + 
		     		"        \r\n" + 
		     		"        \r\n" + 
		     		"        \r\n" + 
		     		"      </ul>\r\n" + 
		     		"      \r\n" + 
		     		"    </div>\r\n" + 
		     		"  </div>\r\n" + 
		     		"</nav>");
		     
		     out.println("<h1>Users List</h1>"); 
		     
		     out.print("<table border='1' width='100%' style='font-size: 15px'>");  
		     out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Contact</th><th>Pan Number</th><th>Aadhar Number</th><th>Type of loan</th><th>Status</th></tr>");
		     LOGGER.info("data is visible to users in the form of table");
		     for(Register r:list){
		    	 //for(Loans l:list1)
		    //	 System.out.println(r.getId());
		    	// System.out.println(r.getName());
		    	 //System.out.println(r.getEmail());
		    	 //System.out.println(r.getContact());
		    	 //System.out.println(r.getPannumber());
		           
		     out.print("<tr><td>"+r.getId()+"</td><td>"+r.getName()+"</td><td>"+r.getEmail()+"</td><td>"+r.getContact()+"</td><td>"+r.getPannumber()+"</td><td>"+r.getAadharnumber()+"</td><td>"+r.getTypeloan()+"</td><td><a href='EmailServlet?id="+r.getId()+" & companyid"+companyid+"'>Approve/deny</a></td></tr>");  
		     out.println("<tr><td></td></tr>");
		     }  
		     out.print("</table>");
		   
		     
	}
	
	

}
