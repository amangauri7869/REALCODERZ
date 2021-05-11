package com.real.controller;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.real.dao.RegisterDao;
import com.real.dao.RegisterDaoImpl;
import com.real.model.Company;
import com.real.model.CompanyLogin;

/**
 * Servlet implementation class EmailServlet
 */
@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
      HttpSession ses=req.getSession();
      
      String companyid=(String) ses.getAttribute("companyid");
		String id=req.getParameter("id");
		//int id=Integer.parseInt(rid);
		String cid=req.getParameter("companyid");
		//int companyid=Integer.parseInt(cid);
		//String email=req.getParameter("email");
		
		System.out.println(id);
		System.out.println(companyid);
		int i=RegisterDaoImpl.approve(id, companyid);
		if(i>0)
		{
			resp.sendRedirect("Company");
			//System.out.println("ssssss");
		}
		else
		{
			resp.sendRedirect("error.jsp");
			System.out.println("outttttttttt");
		}
		
		
		
		//System.out.println(email);
		
		
		
	}
	
	

}
