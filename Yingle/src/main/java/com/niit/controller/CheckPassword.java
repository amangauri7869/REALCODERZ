package com.niit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckPassword
 */
public class CheckPassword extends HttpServlet {
	DataBase obj=new DataBase();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		 PrintWriter out=resp.getWriter();
	        
	        String pass1=req.getParameter("pass1");
	        String pass2=req.getParameter("pass2");
	        //System.out.println(pass1);
	        //System.out.println(pass2);
	        HttpSession session=req.getSession();
	        String email=(String)session.getAttribute("email");
	        System.out.println(email);
	        try{
	        Connection con=obj.initalizedb();
	        Statement st=con.createStatement();
	        if(pass1.equals(pass2))
	        {
	            //System.out.println("successfully changed");
	            String query="update signup set password='"+pass2+"' where email='"+email+"' ";
	            ResultSet rs=st.executeQuery(query);
	            
	            resp.sendRedirect("SignIn.jsp");
	        }
	        else
	        {
	            //System.out.println("sorry password do not match");
	            
	            resp.sendRedirect("IncorrectPassword.jsp");
	            
	            
	        }
	        }catch(Exception e){System.out.println(e); }
	    }

	}


