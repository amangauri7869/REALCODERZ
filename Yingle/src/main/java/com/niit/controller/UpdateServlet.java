package com.niit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		  String username=req.getParameter("username");
	        String email=req.getParameter("email");
	        String password=req.getParameter("password");
	        //System.out.println(email);
	       
	        try{
	        Connection con=DataBase.initalizedb();
	           Statement st=con.createStatement();
	           String query="update signup set username='"+username+"', password='"+password+"' where email='"+email+"' ";
	          int i=st.executeUpdate(query);
	          if(i>0)
	          {
	              System.out.println("inserted");
	          }
	          else
	          {
	              System.out.println("not inserted");
	          }
	            
	        }
	        catch(Exception e)
	        {
	            System.out.println(e);
	        }
	        
	    }

	}


