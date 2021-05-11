package com.real.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.real.dao.AdminDao;
import com.real.dao.AdminDaoImpl;

/**
 * Servlet implementation class DeleteServletCompany
 */
@WebServlet("/DeleteServletCompany")
public class DeleteServletCompany extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(DeleteServletCompany.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		LOGGER.info("inside of doGet method of DeleteServlet Company ");
		 String compid=req.getParameter("companyid");
	        int companyid=Integer.parseInt(compid);
	        AdminDao admin=new AdminDaoImpl();
	        admin.deleteCompany(companyid);
	        //AdminDao.deleteCompany(id);
	        resp.sendRedirect("ViewServlet");
		
	}
	
	
}
