<%@page import="java.sql.*" %>
<%@page import="com.real.database.DbUtility"%>
<%

String fp=request.getParameter("forgot");
if(fp==null || fp.trim().equals(""))
{
out.println("please enter your email");	
}
else
{
//out.println("jdbc code");
  
        try
        {
        	Connection con=DbUtility.getConnection();
        	 PreparedStatement ps=con.prepareStatement("select * from company where companyemail=?");
        	    ps.setString(1, fp);
        	    ResultSet rs=ps.executeQuery();
        	    if(rs.next())
        	    {
        	    out.println("");
        	    }
        	    else
        	    {
        	    	out.println("email id does not exist");
        	    }
        	
        }
        catch(Exception ex)
        {
        	
        }
}






%>