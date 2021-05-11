
<%@page import="com.mysql.cj.exceptions.RSAException"%>
<%@page import="java.sql.*" %>
<%@page import="com.real.model.Company" %>
<%
String s=request.getParameter("val");
if(s==null || s.trim().equals("") )
{
    out.println("enter company name");
}
else
{
    //int id=Integer.parseInt(s);
   // out.println("do the jdbc code");
    try{
    Class.forName("com.mysql.jdbc.Driver");
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loan","root","root");
    
    PreparedStatement ps=con.prepareStatement("select * from company where companyname=?");
    ps.setString(1, s);
    ResultSet rs=ps.executeQuery();
    while(rs.next())
    {
    out.println(rs.getInt(1)+" "+rs.getString(2));
    }
    
    }catch(Exception e)
    {
    System.out.println(e);
    }
}
%>

