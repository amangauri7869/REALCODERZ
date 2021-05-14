package com.niit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ccServlet
 */
public class ccServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		 PrintWriter out=resp.getWriter();
	        String receiver=req.getParameter("createfriend");
	        
	        String message=req.getParameter("message");
	        //System.out.println(createfriend);
	        //System.out.println(message);
	        Date date=new Date();
	         SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
	         SimpleDateFormat sdf2=new SimpleDateFormat("HH-mm-ss");
	         SimpleDateFormat sdf3=new SimpleDateFormat("EEE");
	         String cmtdate=sdf1.format(date);
	         String cmttime=sdf2.format(date);
	         String strdate=sdf3.format(new Date());
	         
	        
	        out.println("<html>\n" +
	"    <head>\n" +
	"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
	"        <title>JSP Page</title>\n" +
	"        <link href=\"dist/css/lib/bootstrap.min.css\" type=\"text/css\" rel=\"stylesheet\">\n" +
	"        <link href=\"dist/css/swipe.min.css\" type=\"text/css\" rel=\"stylesheet\">\n" +
	"    </head>"
	                + "<body class=\"start\">"
	                
	                
	                + "<!-- Start of Sidebar -->\n" +




	"								<h2>message send successfully</h2>\n" +
	"								<p></p>\n" +





	"				<!-- End of Sidebar -->\n" +
	"    </body>\n" +
	"</html>\n" +
	"");
	        
	        HttpSession session=req.getSession();
	        String sender=(String)session.getAttribute("user_name");
	     
	        int result=DataBase.insertcreatechat(sender, receiver, message, cmtdate, cmttime, strdate);
	       System.out.println(result);
	    }
	}


