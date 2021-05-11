package com.real.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.real.dao.AdminDao;
import com.real.dao.AdminDaoImpl;
import com.real.model.Company;

/**
 * Servlet implementation class EditServletCompany
 */
@WebServlet("/EditServletCompany")
public class EditServletCompany extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(EditServletCompany.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		LOGGER.info("Inside DoGet method of the editservletcompany class");
		PrintWriter out=resp.getWriter();
		
		String companyid=req.getParameter("companyid");
		int id1=Integer.parseInt(companyid);
		
		AdminDao admin=new AdminDaoImpl();
		Company c=admin.getUsersByCompany(id1);
		//Company c=AdminDao.getUsersByCompany(id1);
		
		out.println("<h2>Update Company information</h2>");
		 out.print("<form action='EditServlet2c' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='companyid' value='"+c.getCompanyid()+"'/></td></tr>");  
	        out.print("<tr><td>Company Name:</td><td><input type='text' name='companyname' value='"+c.getCompanyname()+"'/></td></tr>");  
	        out.print("<tr><td>Company Address:</td><td><input type='text' name='companyaddress' value='"+c.getCompanyaddress()+"'/></td></tr>");
	        out.print("<tr><td>Company Pan Card:</td><td><input type='number' name='companypan' value='"+c.getCompanypan()+"'/></td></tr>");
	        out.print("<tr><td>Company aadhar:</td><td><input type='number' name='companyaadhar' value='"+c.getCompanyaadhar()+"'/></td></tr>");
	        out.print("<tr><td>Company Number:</td><td><input type='number' name='companynumber' value='"+c.getCompanynumber()+"'/></td></tr>");
	        out.print("<tr><td>Company Email:</td><td><input type='email' name='companyemail' value='"+c.getCompanyemail()+"'/></td></tr>");          
	        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>");  
	        
	
	}
	
	

}
