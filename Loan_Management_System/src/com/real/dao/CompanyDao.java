package com.real.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import com.real.controller.FpCode;
import com.real.database.DbUtility;
import com.real.model.Company;
import com.real.model.CompanyLogin;
import com.real.model.Loans;
import com.real.model.Register;


public class CompanyDao {

	static final Logger LOGGER = Logger.getLogger(RegisterDaoImpl.class);
	//This is to save the details of the company
	public static int save(Company c)
	
	
	{
		LOGGER.info("Connection is established and data is being inserted in mysql database");
	    int roll=0;
		try {
			Connection con=DbUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into company(companyname, companyaddress, companypan, companyaadhar, companynumber, companyemail, companypassword) values(?,?,?,?,?,?,?)");
			ps.setString(1,c.getCompanyname());
			ps.setString(2,c.getCompanyaddress());
			ps.setString(3,c.getCompanypan());
			ps.setString(4,c.getCompanyaadhar());
			ps.setString(5,c.getCompanynumber());
		    ps.setString(6,c.getCompanyemail());
		    ps.setString(7,c.getCompanypassword());
		    
			roll=ps.executeUpdate();
			
		}catch(Exception ex) { }
		
		
		return roll;
		
		
	}
	//This is the code to generate random string for users who have forgotten their passwords   
	   public String insert()
	           
	     {
		   LOGGER.info("This method is used to generate a random code for companies who have forgotten their passwords");
	         FpCode f=new FpCode();
	         
	          String code="";
	         
	     try{    
	         Connection con=DbUtility.getConnection();
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
	
	   
	   public static List<Loans> getStatus()
	   {
		   List<Loans> list=new ArrayList<Loans>();
		   try {
			   Connection con=DbUtility.getConnection();
			   PreparedStatement ps=con.prepareStatement("select * from loans");
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   Loans l=new Loans();
				   l.setId(rs.getInt(1));
				   l.setCompanyid(rs.getInt(2));
				   l.setStatus(rs.getString(3));
				   list.add(l);
			   }
			   
			   
		   }catch(Exception e) {}
		   
		   return list;
	   }
	   
	   public static List<Company> id()
		{
			List<Company> list=new ArrayList<Company>();
			try {
	    	Connection con=DbUtility.getConnection();
	    	PreparedStatement ps=con.prepareStatement("select max(companyid) from company");
	    	ResultSet rs=ps.executeQuery();
	    	while(rs.next())
	    	{
	    		Company co=new Company();
	    		co.setCompanyid(rs.getInt(1));
	    		list.add(co);
	    	}
	    	
			
			} catch(Exception e) { System.out.println(e); }
			System.out.println(list);
			return list;
		}
	
}
