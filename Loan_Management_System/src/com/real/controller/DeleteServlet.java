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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	
	static final Logger LOGGER = Logger.getLogger(DeleteServlet.class);
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
		 LOGGER.info("Inside doGet method of DeleteServlet");
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);
        AdminDao admin=new AdminDaoImpl();
        LOGGER.info("delete method is called from admindao");
        admin.delete(id);
        //AdminDao.delete(id);
        response.sendRedirect("ViewServlet"); 
        
       
        
        
    }  
}
