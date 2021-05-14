 <%-- 
    Document   : FP code
    Created on : 27 May, 2020, 9:45:46 AM
    Author     : AMAN
--%>

<%@page import="java.awt.BorderLayout"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.PasswordAuthentication"%>
<%@page import="javax.mail.Session"%>
<%@page import="java.util.Properties"%>
<%@page import="com.niit.controller.DataBase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            /* ResultSet rs=null;
         String femail=request.getParameter("email");
         DataBase db=new DataBase();
         Connection con=DataBase.initalizedb();
         Statement st=con.createStatement();
         String query="select * from signup where email='"+femail+"' ";
         rs=st.executeQuery(query);
         if(rs.next())
         {
           final String username = "gauri.aman0@gmail.com";
         final String password = "jxxjystgnshkhazz";
         

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session1 = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
          }
          });

        try {

            Message message = new MimeMessage(session1);
            message.setFrom(new InternetAddress("gauri.aman0@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(femail));
            message.setSubject("Testing Subject  ");
            
            message.setText("Dear Mail Crawler, '"+db.insert()+"'      "
                + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Done");

        } catch (Exception e) {
            System.out.println(e);
        }
        response.sendRedirect("ForgotPassword.jsp");
         }
         
         else
         {
          System.out.println("not a valid user");
         }*/
         
      
         
        %>
    </body>
</html>
