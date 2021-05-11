package com.real.model;

import org.apache.log4j.Logger;

import com.real.dao.RegisterDaoImpl;

public class Admin {

	
	private String id;
	private String password;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", password=" + password + "]";
	}
	
	
}
