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
import com.real.model.Register;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(EditServlet2.class);
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		LOGGER.info("Inside of edit servlet(user)");
		PrintWriter out=resp.getWriter();
		
		String sid=req.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=req.getParameter("name");  
        String email=req.getParameter("email");  
        String contact=req.getParameter("contact");
        String pannumber=req.getParameter("pannumber");
        String aadharnumber=req.getParameter("aadharnumber");
        String typeloan=req.getParameter("typeloan");
        Register r=new Register();
        r.setId(id);
        r.setName(name);
        r.setEmail(email);
        r.setContact(contact);
        r.setPannumber(pannumber);
        r.setAadharnumber(aadharnumber);
        r.setTypeloan(typeloan);
        
        AdminDao admin=new AdminDaoImpl();
        boolean r1=admin.update(r);
        
        resp.sendRedirect("ViewServlet");
        //int roll=AdminDao.update(r);
        //if(roll>0)
       // {
        //	resp.sendRedirect("ViewServlet");
        //}
        //else
        //{
        	
        	//resp.sendRedirect("ViewServlet");
        //}
      /* 
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
      	
		int roll1=AdminDao.updateCompany(c);
		if(roll1>0)
        {
        	resp.sendRedirect("ViewServlet");
        }
        else
        {
        	out.println("sorry unable to update");
        	resp.sendRedirect("ViewServlet");
        }           */
	}

}