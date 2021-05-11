package com.real.testing;

import static org.junit.Assert.*;

import java.awt.Checkbox;
import java.util.List;

import org.junit.Test;

import com.real.controller.AdminServlet;
import com.real.controller.CheckPassword;
import com.real.controller.CompanyServlet;
import com.real.dao.AdminDao;
import com.real.dao.AdminDaoImpl;
import com.real.dao.CompanyDao;
import com.real.dao.RegisterDaoImpl;
import com.real.model.Admin;
import com.real.model.Company;
import com.real.model.CompanyLogin;
import com.real.model.Register;

public class AdminTest {
	
	@Test
	public void update()
	{
		Register r=new Register();
		AdminDaoImpl ad=new AdminDaoImpl();
		ad.update(r);
		assertEquals(true, ad.update(r));
			
	}
	@Test
	public void updateCompany()
	{
		Company c=new Company();
		AdminDaoImpl ad=new AdminDaoImpl();
		ad.updateCompany(c);
		assertEquals(true, ad.updateCompany(c));
		
	}
	@Test
	public void delete()
	{
		Register r=new Register();
		AdminDaoImpl ad=new AdminDaoImpl();
		ad.delete(12);
		assertEquals(false, ad.delete(12));
		
	}
	@Test
	public void deletecomp()
	{
		Company c=new Company();
		AdminDaoImpl ad=new AdminDaoImpl();
		ad.deleteCompany(23);
		assertEquals(true, ad.deleteCompany(23));
	}
	@Test
	public void getAllUsers()
	{
		Register r=new Register();
		AdminDaoImpl ad=new AdminDaoImpl();
		ad.getAllUsers();
		assertNotEquals(true, ad.getAllUsers());
	}
	@Test
	public void getEmpById()
	{
		AdminDaoImpl ad=new AdminDaoImpl();
		ad.getEmployeeById(10);
		assertNotEquals(10, ad.getEmployeeById(10));
	}
	@Test
	public void getComp()
	{
		AdminDao ad=new AdminDaoImpl();
		ad.getUsersByCompany(23);
		assertNotEquals(23, ad.getUsersByCompany(23));
	}
	@Test
	public void getCompany()
	{
		AdminDao ad=new AdminDaoImpl();
		ad.getAllCompany();
		assertNotEquals(true, ad.getAllCompany());
	}
	@Test
	public void companyRegistration()
	{
		Company c=new Company();
		CompanyDao cd=new CompanyDao();
		cd.save(c);
		assertEquals(0, cd.save(c));
		
	}
	@Test
	public void companyid()
	{
		Company c=new Company();
		CompanyDao cd=new CompanyDao();
		cd.id();
		assertNotEquals(true, cd.id());
	}
	@Test
	public void status()
	{
		CompanyDao cd=new CompanyDao();
		cd.getStatus();	
		assertNotEquals(true, cd.getStatus());
	}
	@Test
	public void approve()
	{
		AdminDaoImpl ad=new AdminDaoImpl();
		ad.Approve(10);
		assertEquals(0, ad.Approve(10));
	}
	@Test
	public void whenUserGetsRegister()
	{
		Register r=new Register();
		r.getId();
		assertEquals("data is not inserted", 0, r.getId());
	}
	@Test
	public void name()
	{
		Register r=new Register();
		r.getName();
		assertEquals("name", null, r.getName());
	}
	@Test
	public void email()
	{
		Register r=new Register();
		r.getEmail();
		assertEquals(null, r.getEmail());
	}
	@Test
	public void contact()
	{
		Register r=new Register();
		r.getContact();
		assertEquals(null, r.getContact());
	}
	@Test
	public void pannumber()
	{
		Register r=new Register();
		r.getPannumber();
		assertEquals(null, r.getPannumber());
	}
	@Test
	public void aadharnumber()
	{
		Register r=new Register();
		r.getAadharnumber();
		assertEquals(null, r.getAadharnumber());
	}
	@Test
	public void typeloan()
	{
		Register r=new Register();
		r.getTypeloan();
		assertEquals(null, r.getTypeloan());
		
	}
	@Test
	public void register()
	{
		Register r=new Register();
		RegisterDaoImpl rd=new RegisterDaoImpl();
		rd.insert(r);
		assertEquals(false, rd.insert(r));
	}
	@Test
	public void app()
	{
		Register r=new Register();
		RegisterDaoImpl rd=new RegisterDaoImpl();
		rd.approve("10", "24");
		assertEquals(0, rd.approve("10", "24"));
	}
	@Test
	public void whenCompanyGetsRegistered()
	{
		Company c=new Company();
		c.getCompanyid();
		assertEquals(0, c.getCompanyid());
	}
	@Test
	public void complogin()
	{
		CompanyLogin cl=new CompanyLogin();
		cl.getCompanyemail();
		assertEquals(null, cl.getCompanyemail());
		
	}
	@Test
	public void comploginpassword()
	{
		CompanyLogin cl=new CompanyLogin();
		cl.getCompanypassword();
		assertEquals(null, cl.getCompanypassword());
	}
	@Test
	public void comServlet()
	{
		Company c=new Company();
	      AdminDao ad=new AdminDaoImpl();
	      ad.updateCompany(c);
	      
	}
}
