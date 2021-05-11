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
 * Servlet implementation class EditServlet2c
 */
@WebServlet("/EditServlet2c")
public class EditServlet2c extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(EditServlet2c.class); 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		LOGGER.info("inside doPost of editservlet company");
		PrintWriter out=resp.getWriter();
		
		 String companyid=req.getParameter("companyid");
	        int id1=Integer.parseInt(companyid);
	        String companyname=req.getParameter("companyname");
			String companyaddress=req.getParameter("companyaddress");
			String companypan=req.getParameter("companypan");
			String companyaadhar=req.getParameter("companyaadhar");
			String companynumber=req.getParameter("companynumber");
			String companyemail=req.getParameter("companyemail");
	        
	        Company c=new Company();
			
			c.setCompanyname(companyname);
			c.setCompanyaddress(companyaddress);
			c.setCompanypan(companypan);
			c.setCompanyaadhar(companyaadhar);
			c.setCompanynumber(companynumber);
			c.setCompanyemail(companyemail);
	      	
			System.out.println(companyaadhar);
			
			AdminDao admin=new AdminDaoImpl();
			boolean c1=admin.updateCompany(c);
			
		//	int roll=AdminDao.updateCompany(c);
			//if(roll>0)
	       // {
	        	resp.sendRedirect("ViewServlet");
	        //}
	        //else
	        //{
	        //	out.println("sorry unable to update");
	        	//resp.sendRedirect("ViewServlet");
	        //}    
		
	}
	
	
	
}
