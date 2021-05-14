package com.niit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Code
 */


public class Code extends HttpServlet {
	FPcode f=new FPcode();


	DataBase db=new DataBase();
	
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			 String c=req.getParameter("code");
		        //System.out.println(c);
		        try{
		             Connection con=db.initalizedb();
		             Statement st=con.createStatement();
		             
		             //This is to verify the code of the user
		             String query="select * from signup where code='"+c+"' ";
		             ResultSet rs=st.executeQuery(query);
		             if(rs.next())
		             {
		                 System.out.println("enter new password");
		                 resp.sendRedirect("NewPassword.jsp");
		             }
		             else
		             {
		                 System.out.println("sssssss");
		             }
		        
		        }
		        catch(Exception e){
		            System.out.println(e);
		        }
		        
		    }

			
	}


