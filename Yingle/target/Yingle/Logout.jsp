<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.niit.controller.DataBase"%>
<%
  session.setAttribute("user_name", null);
session.invalidate();
DataBase db=new DataBase();
Connection con=db.initalizedb();
Statement st=con.createStatement();

response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%out.println("<html>\n" +
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


"								<h2>You Have been Logged Out Successfully</h2>\n" +
"								<p>To keep connected with your friends and family please signup with your personal details.</p>\n" +
"								<a href=\"SignIn.jsp\" class=\"btn button\">Sign In</a>\n" +


"					</div>\n" +
"				</div>\n" +
"				<!-- End of Sidebar -->\n" +
"    </body>\n" +
"</html>\n" +
"");%>
    </body>
</html>
