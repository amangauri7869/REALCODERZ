package com.real.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.real.database.DbUtility;
import com.real.exception.MyException;
import com.real.model.Company;
import com.real.model.CompanyLogin;
/**
 * Servlet implementation class CompanyLogin
 */
@WebServlet("/CompLogin")
public class CompLogin extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(CompLogin.class);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	LOGGER.info("inside doPost method of companylogin servlet");
		
		Boolean status=false;
		PrintWriter out=resp.getWriter();
		try {
			Connection con=DbUtility.getConnection();
			Statement st=con.createStatement();
			String companyemail=req.getParameter("companyemail");
			String companypassword=req.getParameter("companypassword");
			String companyid=req.getParameter("companyid");
			Company c=new Company();

	        String query="select * from company where companyemail= '"+companyemail+"' and companypassword= '"+companypassword+"' and companyid='"+companyid+"' ";
	        
	        //throw new MyException();
	        
	        
           ResultSet rs=st.executeQuery(query);
           if(rs.next())
           {
        	  LOGGER.info("session has been created");
        	   HttpSession session=req.getSession();
		  	   //session.removeAttribute("user_name");
		  	   session.setAttribute("user_name", companyemail);
		  	   session.setAttribute("companyid", companyid);
		  	 //System.out.println(companyid);
		  	   System.out.println("login successful");
		  	   LOGGER.info("if successfull it redirect you to company");
        	   resp.sendRedirect("Company");
        	   
           }
           else
           {
        	   LOGGER.info("else error page");
        	   resp.sendRedirect("error.jsp");
        	   System.out.println("login again");
           }
           LOGGER.error("exception occured check the data");
			
		}catch(Exception ex) { System.out.println(ex); }
		
	
       
		
		
	}
	
	
	

}
