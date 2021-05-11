package com.real.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.real.dao.AdminDao;
import com.real.dao.AdminDaoImpl;

/**
 * Servlet implementation class ApproveServlet
 */
@WebServlet("/ApproveServlet")
public class ApproveServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out=resp.getWriter();
		
		String rid=req.getParameter("id");
		int id=Integer.parseInt(rid);
        int i=AdminDaoImpl.Approve(id);
		resp.sendRedirect("ViewServlet");		
		
		
	
		
	}
	
	

}
