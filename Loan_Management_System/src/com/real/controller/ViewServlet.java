package com.real.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.real.dao.AdminDao;
import com.real.dao.AdminDaoImpl;
import com.real.model.Company;
import com.real.model.Register;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(ViewServlet.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
		LOGGER.info("inside dopost method of viewservlet ");
     response.setContentType("text/html"); 
     PrintWriter out=response.getWriter();  
    // PrintWriter in=response.getWriter();
      
 
     AdminDao admin=new AdminDaoImpl();
     List<Register> list=admin.getAllUsers();
     List<Company> lis=admin.getAllCompany();
     
     
     
     //List<Register> list= AdminDao.getAllUsers();  
     //List<Company> lis=AdminDao.getAllCompany();
     
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
     out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Contact</th><th>Pan Number</th><th>Aadhar Number</th><th>Type of loan</th><th>Edit</th><th>Delete</th></tr>");  
     for(Register r:list){
    //	 System.out.println(r.getId());
    	// System.out.println(r.getName());
    	 //System.out.println(r.getEmail());
    	 //System.out.println(r.getContact());
    	 //System.out.println(r.getPannumber());
     out.print("<tr><td>"+r.getId()+"</td><td>"+r.getName()+"</td><td>"+r.getEmail()+"</td><td>"+r.getContact()+"</td><td>"+r.getPannumber()+"</td><td>"+r.getAadharnumber()+"</td><td>"+r.getTypeloan()+"</td><td><a href='EditServlet?id="+r.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+r.getId()+"'>delete</a></td></tr>");  
     }  
     out.print("</table>");
     
     out.println("<h1>Company List</h1>");  
     out.print("<table border='1' width='100%' style='font-size: 15px'>");  
     out.print("<tr><th>Id</th><th>Company Name</th><th>company address</th><th>Company Pan</th><th>Company Aadhar</th><th>Company Number</th><th>Company Email</th><th>Edit</th><th>Delete</th></tr>");  
     for(Company c:lis){
     //System.out.println(c.getId());
     //System.out.println(c.getCompanyname());
     //System.out.println(c.getCompanyaddress());
    ///System.out.println(c.getCompanypan());
    ///System.out.println(c.getCompanyaadhar());
    ///System.out.println(c.getCompanynumber());
    ///System.out.println(c.getCompanyemail());
    	 
     out.print("<tr><td>"+c.getCompanyid()+"</td><td>"+c.getCompanyname()+"</td><td>"+c.getCompanyaddress()+"</td><td>"+c.getCompanypan()+"</td><td>"+c.getCompanyaadhar()+"</td><td>"+c.getCompanynumber()+"</td><td>"+c.getCompanyemail()+"</td><td><a href='EditServletCompany?companyid="+c.getCompanyid()+"'>edit</a></td><td><a href='DeleteServletCompany?companyid="+c.getCompanyid()+"'>delete</a></td></tr>");  
     }  
     out.print("</table>");
     
     out.println("<footer>\r\n" + 
     		"\r\n" + 
     		"<!--  <div id=\"bottom\">\r\n" + 
     		"<a href=\"#\">Home</a> | <a href=\"#\">About Us</a> | <a href=\"#\">Contact Us</a> |<a href=\"#\"> Support</a> | <a href=\"#\">Products</a> | <a href=\"#\">Services</a>\r\n" + 
     		"<div class=\"clear\"></div>\r\n" + 
     		"</div>-->\r\n" + 
     		"<div id=\"credits\">\r\n" + 
     		"2021 &copy; All Rights Reserved.  </div>\r\n" + 
     		"</footer>\r\n" + 
     		"\r\n" + 
     		"</body>\r\n" + 
     		"</html>");
     
     
     
     
     
     
     
     
     
     
     
	}
}
     
 
	
  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

