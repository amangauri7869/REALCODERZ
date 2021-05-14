package com.niit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.SignUpDao;
import com.niit.dao.SignUpDaoImpl;
import com.niit.model.SignUp;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		 PrintWriter out=resp.getWriter();
	        
		 
	        String username=req.getParameter("username");
	        String email=req.getParameter("email");
	        String password=req.getParameter("password");
	        
	        SignUp signup=new SignUp();
	        
	        signup.setUsername(username);
	        signup.setEmail(email);
	        signup.setPassword(password);
	        
	        SignUpDao signupdao=new SignUpDaoImpl();
	        signupdao.insert(signup);
	        
	              out.println("<html>\n" +
	"    <head>\n" +
	"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
	"        <title>JSP Page</title>\n" +
	"        <link href=\"dist/css/lib/bootstrap.min.css\" type=\"text/css\" rel=\"stylesheet\">\n" +
	"        <link href=\"dist/css/swipe.min.css\" type=\"text/css\" rel=\"stylesheet\">\n" +
	"    </head>"
	                + "<body class=\"start\">"
	                
	                
	                + "<!-- Start of Sidebar -->\n" +
	"				<div class=\"aside order-md-1\">\n" +
	"					<div class=\"container\">\n" +


	"								<h2>Registered Successfully</h2>\n" +
	"								<p>To keep connected with your friends and family please login with your personal details.</p>\n" +
	"								<a href=\"SignIn.jsp\" class=\"btn button\">Sign In</a>\n" +


	"					</div>\n" +
	"				</div>\n" +
	"				<!-- End of Sidebar -->\n" +
	"    </body>\n" +
	"</html>\n" +
	"");
	         
	}

}
