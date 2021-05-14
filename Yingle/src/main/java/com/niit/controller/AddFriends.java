package com.niit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddFriends
 */
public class AddFriends extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		 PrintWriter out=resp.getWriter();
	       out.println("<!-- Start of Sidebar -->\n" +
	"				<div class=\"aside order-md-1\">\n" +
	"					<div class=\"container\">\n" +
	"						<div class=\"col-md-12\">\n" +
	"							<div class=\"preference\">\n" +
	"								<h2>Friend Added SuccessFully</h2>\n" +
	"								<p>To keep connected with your friends please login with your personal info.</p>\n" +
	"								<a href=\"index.jsp\" class=\"btn button\">Back</a>\n" +
	"							</div>\n" +
	"						</div>\n" +
	"					</div>\n" +
	"				</div>\n" +
	"				<!-- End of Sidebar -->");
	        
	        
	        String adduser=req.getParameter("adduser");
	        String text=req.getParameter("text");
	        HttpSession session=req.getSession();
	        String sender=(String)session.getAttribute("user_name");
	        //System.out.println(adduser);
	        //System.out.println(text);
	        
	        int result=DataBase.insertfriends(adduser, text, sender);
	        System.out.println(result);
	        
	       
	}

}
