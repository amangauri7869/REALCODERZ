package com.niit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DataBase extends HttpServlet {
	
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        
	        HttpSession session=req.getSession();
	        String sender=(String)session.getAttribute("user_name");
	    
	    
	   
	    }   
	    
	    public static Connection initalizedb() throws ClassNotFoundException, SQLException
	    {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","sql@2012");
	    return con;
	    }

	    
	   // add contacts goes here 
	    public static int insertfriends(String adduser, String text, String sender)
	    {
	    int flag=0;
	    try{
	    Connection con=DataBase.initalizedb();
	        PreparedStatement ps=con.prepareStatement("insert into afriends values(?,?,?)");
	        ps.setString(1, adduser);
	        
	        ps.setString(2, text);
	        ps.setString(3, sender);
	        flag=ps.executeUpdate();
	    }
	    catch(Exception e)
	    {
	        System.out.println(e);
	    }
	    return flag;
	    }
	    
	    
	    // retreive of contact code goes here
	    public ResultSet getcontacts()
	    {
	      Connection con;
	      Statement st;
	      ResultSet rs=null;
	      
	      try{
	           con=DataBase.initalizedb();
	           st=con.createStatement();
	           String query;
	           query="select * from afriends " ;
	           rs=st.executeQuery(query);
	      
	      }
	      catch(Exception e){
	          System.out.println(e);
	      }
	      return rs;
	    }
	    
	    
	    // insert of create chat code goes here
	   public static int insertcreatechat(String sender, String receiver, String message, String cmtdate, String cmttime, String strdate)
	    {
	    int flag=0;
	    try{
	         Connection con=DataBase.initalizedb();
	         PreparedStatement ps=con.prepareStatement("insert into newchat values(?,?,?,?,?,?)");
	         ps.setString(1, sender);
	         ps.setString(2, receiver);
	         ps.setString(3, message);
	         ps.setString(4, cmtdate);
	         ps.setString(5, cmttime);
	         ps.setString(6, strdate);
	         flag=ps.executeUpdate();
	         
	    }
	    catch(Exception e)
	    {
	        System.out.println(e);
	    }
	    return flag;
	    }
	   
	   
	    // retrieve of discussions code
	   public ResultSet getnewchat()
	   {
	     Connection con;
	     Statement st;
	     ResultSet rs=null; 
	     
	     try{
	           con=DataBase.initalizedb();
	           st=con.createStatement();
	           String query="select * from newchat";
	           rs=st.executeQuery(query);
	     }
	     catch(Exception e)
	     {
	         System.out.println(e);
	     }
	        return rs;
	  
	   }
	   
	   
	   
	//This is the code to generate random string for users who have forgotten their passwords   
	   public String insert()
	           
	     {
	         FPcode f=new FPcode();
	         
	          String code="";
	         
	     try{    
	         Connection con=DataBase.initalizedb();
	   Statement st=con.createStatement();
	   
	     
	 
	              String characters="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	            
	             int length=5;
	             
	             Random rand=new Random();
	             
	             char[] text=new char[length];
	             
	             for(int i=0;i<length;i++)
	             {
	             text[i]= characters.charAt(rand.nextInt(characters.length()));
	             }
	             for(int i=0;i<text.length;i++)
	             {
	             code +=text[i];
	             }
	             System.out.println(code);
	             
	            // String query="update signup set code='"+code+"' ";
	             //int rs=st.executeUpdate(query);
	             System.out.println(code);
	     }
	     catch(Exception e)
	     {
	         System.out.println(e);
	     }        
	         
	     return code;
	     }

}
