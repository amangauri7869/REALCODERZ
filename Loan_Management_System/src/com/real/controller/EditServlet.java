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
import com.real.dao.RegisterDao;
import com.real.model.Company;
import com.real.model.Register;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(EditServlet.class);
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		LOGGER.info("inside edit servlet of update user");
		PrintWriter out=resp.getWriter();
		out.println("<h1>Update User</h1>");
		
		String sid=req.getParameter("id");
		int id=Integer.parseInt(sid);
	//	String companyid=req.getParameter("companyid");
		//int id1=Integer.parseInt(companyid);
		AdminDao admin=new AdminDaoImpl();
		Register r=admin.getEmployeeById(id);
		
		//Register r=AdminDao.getEmployeeById(id);  
        //Company c=AdminDao.getUsersByCompany(id1);
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+r.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+r.getName()+"'/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+r.getEmail()+"'/></td></tr>");
        out.print("<tr><td>Contact:</td><td><input type='number' name='contact' value='"+r.getContact()+"'/></td></tr>");
        out.print("<tr><td>Pan number:</td><td><input type='text' name='pannumber' value='"+r.getPannumber()+"'/></td></tr>");
        out.print("<tr><td>Aadhar Number:</td><td><input type='number' name='aadharnumber' value='"+r.getAadharnumber()+"'/></td></tr>");
        out.print("<tr><td>Type of loan:</td><td><input type='text' name='typeloan' value='"+r.getTypeloan()+"'/></td></tr>");          
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
         
      /* out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+c.getCompanyid()+"'/></td></tr>");  
        out.print("<tr><td>Company Name:</td><td><input type='text' name='name' value='"+c.getCompanyname()+"'/></td></tr>");  
        out.print("<tr><td>Company Address:</td><td><input type='email' name='email' value='"+c.getCompanyaddress()+"'/></td></tr>");
        out.print("<tr><td>Company Pan Card:</td><td><input type='number' name='contact' value='"+c.getCompanypan()+"'/></td></tr>");
        out.print("<tr><td>Company aadhar:</td><td><input type='text' name='pannumber' value='"+c.getCompanyaadhar()+"'/></td></tr>");
        out.print("<tr><td>Company Number:</td><td><input type='number' name='aadharnumber' value='"+c.getCompanynumber()+"'/></td></tr>");
        out.print("<tr><td>Company Email:</td><td><input type='text' name='typeloan' value='"+c.getCompanyemail()+"'/></td></tr>");          
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
        
        */
        
        
        
        
        
        
    }  

		
}
