package com.niit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignInServlet
 */
public class SignInServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 boolean status=false;
         PrintWriter out=resp.getWriter();
         try{
        resp.setContentType("text/html");
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","sql@2012");
        Statement st=con.createStatement();
        
        
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        
        String query="select * from signup where email= '"+email+"' and password='"+password+"' ";
        
        ResultSet rs=st.executeQuery(query);
        if(rs.next())
        {
            HttpSession session=req.getSession();
            session.setAttribute("user_name", email);
           // String query1="update signup set status='Y' where email='"+email+"' ";
            //ResultSet rs1=st.executeQuery(query1);
            resp.sendRedirect("index.jsp");
           
        }
        else
        {
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


"								<h2>Sorry your credintials are wrong</h2>\n" +
"								<p>To keep connected with your friends and family please signup with your personal details.</p>\n" +
"								<a href=\"SignUp.jsp\" class=\"btn button\">Sign Un</a>\n" +


"					</div>\n" +
"				</div>\n" +
"				<!-- End of Sidebar -->\n" +
"    </body>\n" +
"</html>\n" +
"");
        }
        
         }
         catch(Exception e)
         {
          System.out.println(e);
         }

	}

}
