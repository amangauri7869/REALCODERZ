package com.real.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.real.database.DbUtility;

/**
 * Servlet implementation class ForgotAjax
 */
@WebServlet("/ForgotAjax")
public class ForgotAjax extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out=resp.getWriter();
		String fp=req.getParameter("forgot");
		if(fp==null || fp.trim().equals(""))
		{
		out.println("please enter your email");	
		}
		else
		{
		//out.println("jdbc code");
		  
		        try
		        {
		        	Connection con=DbUtility.getConnection();
		        	 PreparedStatement ps=con.prepareStatement("select * from company where companyemail=?");
		        	    ps.setString(1, fp);
		        	    ResultSet rs=ps.executeQuery();
		        	    if(rs.next())
		        	    {
		        	    out.println("");
		        	    }
		        	    else
		        	    {
		        	    	out.println("email id does not exist");
		        	    }
		        	
		        }
		        catch(Exception ex)
		        {
		        	
		        }
		}
	}
}
	


	

