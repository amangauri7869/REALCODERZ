package com.real.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.real.controller.RegisterServlet;
import com.real.database.DbUtility;
import com.real.model.Company;
import com.real.model.Register;

public class AdminDaoImpl implements AdminDao {

	static final Logger LOGGER = Logger.getLogger(AdminDaoImpl.class);
	@Override
	public boolean update(Register r) {
		 //To update the register table those who apply for loan
LOGGER.info("this is the update method which admin can perform");
		{
			int roll=0;
			try {
				Connection con=DbUtility.getConnection();
				PreparedStatement ps=con.prepareStatement("update register set name=?,email=?,contact=?,pannumber=?,aadharnumber=?,typeloan=? where id=?");
				ps.setString(1,r.getName());
				ps.setString(2,r.getEmail());
				ps.setString(3,r.getContact());
				ps.setString(4,r.getPannumber());
				ps.setString(5,r.getAadharnumber());
				ps.setString(6,r.getTypeloan());
				ps.setInt(7,r.getId());
				roll=ps.executeUpdate();
				
			}catch(Exception ex) { System.out.println(ex); }
			return true;
		}
	}

	@Override
	public boolean updateCompany(Company c) {
		LOGGER.info("this is the update method of the company");
		//To update the company table for people who registered as a company
		int roll=0;
		try {
			Connection con=DbUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("update company set companyname=?,companyaddress=?,companypan=?,companyaadhar=?,companynumber=?,companyemail=? where companyid=?");
			ps.setString(1,c.getCompanyname());
			ps.setString(2,c.getCompanyaddress());
			ps.setString(3,c.getCompanypan());
			ps.setString(4,c.getCompanyaadhar());
			ps.setString(5,c.getCompanynumber());
			ps.setString(6,c.getCompanyemail());
			ps.setInt(7,c.getCompanyid());
			roll=ps.executeUpdate();
			
		}catch(Exception ex) { System.out.println(ex); }
		
		return true;
	}

	@Override
	public Register getEmployeeById(int id) {
		LOGGER.info("this is the method used to reterive data from a specific id");
		//To get the records of a particular user by his or her user id 
Register r=new Register();
		
		try {
			Connection con=DbUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from register where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if (rs.next())
			{
				r.setId(rs.getInt(1));
				r.setName(rs.getString(2));
				r.setEmail(rs.getString(3));
				r.setContact(rs.getString(4));
				r.setPannumber(rs.getString(5));
				r.setAadharnumber(rs.getString(6));
				r.setTypeloan(rs.getString(7));
			}
			
		}catch(Exception ex) { System.out.println(ex); }
		
		return r ;
	}

	@Override
	public Company getUsersByCompany(int id) {
		LOGGER.info("this method is used to take a company by specific id");
		//To get the records of a particular company by his or her id
Company c=new Company();
		
		try {
			Connection con=DbUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from company where companyid=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if (rs.next())
			{
				c.setCompanyid(rs.getInt(1));
				c.setCompanyname(rs.getString(2));
				c.setCompanyaddress(rs.getString(3));
				c.setCompanypan(rs.getString(4));
				c.setCompanyaadhar(rs.getString(5));
				c.setCompanynumber(rs.getString(6));
				c.setCompanyemail(rs.getString(7));
			}
			
		}catch(Exception ex) { System.out.println(ex); }
		
		return c;
	}

	@Override
	public boolean delete(int id) {
		LOGGER.info("This method is used to delete the user");
		// to delete the record of user
		int roll=0;
		try {
			Connection con=DbUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from register where id=?");
			ps.setInt(1,id);
			
			roll=ps.executeUpdate();
			
		}catch(Exception ex) { System.out.println(ex); }
		
		return false;
	}

	@Override
	public boolean deleteCompany(int companyid) {
		LOGGER.info("this method is used to delete the company");
		//to delete company from user
		int roll=0;
		try {
			Connection con=DbUtility.getConnection();
			PreparedStatement ps1=con.prepareStatement("delete from company where companyid=?");
			ps1.setInt(1,companyid);
			
			roll=ps1.executeUpdate();
			
		}catch(Exception ex) { System.out.println(ex); }
		
		return true;
	}

	@Override
	public List<Register> getAllUsers() {
		LOGGER.info("This method is used to display all the user who are registered");
		// displays all the details to admin table
		List<Register> list=new ArrayList<Register>();
		try {
    	Connection con=DbUtility.getConnection();
    	PreparedStatement ps=con.prepareStatement("select * from register");
    	ResultSet rs=ps.executeQuery();
    	while(rs.next())
    	{
    		Register r=new Register();
    		r.setId(rs.getInt(1));
    		r.setName(rs.getString(2));
    		r.setEmail(rs.getString(3));
    		r.setContact(rs.getString(4));
    		r.setPannumber(rs.getString(5));
    		r.setAadharnumber(rs.getString(6));
    		r.setTypeloan(rs.getString(7));
    		list.add(r);
    	}
    	
		
		} catch(Exception e) { System.out.println(e); }
		System.out.println(list);
		return list;
	}

	@Override
	public List<Company> getAllCompany() {
		LOGGER.info("This method is used to display all the company who are registered as a company");
		//displays all the details to admin table
		List<Company> list=new ArrayList<Company>();
		try {
    	Connection con=DbUtility.getConnection();
    	PreparedStatement ps=con.prepareStatement("select * from company");
    	ResultSet rs=ps.executeQuery();
    	while(rs.next())
    	{
    		Company c=new Company();
    	    c.setCompanyid(rs.getInt(1));
    	    c.setCompanyname(rs.getString(2));
    	    c.setCompanyaddress(rs.getString(3));
    	    c.setCompanypan(rs.getString(4));
    	    c.setCompanyaadhar(rs.getString(5));
    	    c.setCompanynumber(rs.getString(6));
    	    c.setCompanyemail(rs.getString(7));
    	    list.add(c);
    	}
    	
		
		} catch(Exception e) { System.out.println(e); }
		System.out.println(list);
		return list;
	}
	
	public static int Approve(int id)
	{
		int roll=0;
		try {
			Connection con=DbUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("update register set status=? where id=?");
			ps.setBoolean(1, true);
			ps.setInt(2, id);
			
			roll=ps.executeUpdate();
			
		}catch(Exception ex) { System.out.println(ex); }
		
		return roll;
	}
   
	
}
