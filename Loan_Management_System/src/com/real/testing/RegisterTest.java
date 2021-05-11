package com.real.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.real.dao.RegisterDao;
import com.real.dao.RegisterDaoImpl;
import com.real.model.Register;

public class RegisterTest {

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
	}
	@Test
	public void app()
	{
		Register r=new Register();
		RegisterDaoImpl rd=new RegisterDaoImpl();
		rd.approve("10", "24");
	}
	
	
	
	
}
