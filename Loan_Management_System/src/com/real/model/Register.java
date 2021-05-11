package com.real.model;

public class Register {

	private int id;
	private String name;
	private String email;
	private String contact;
	private String pannumber;
	private String aadharnumber;
	private String typeloan;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPannumber() {
		return pannumber;
	}
	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}
	public String getAadharnumber() {
		return aadharnumber;
	}
	public void setAadharnumber(String aadharnumber) {
		this.aadharnumber = aadharnumber;
	}
	
	
	public String getTypeloan() {
		return typeloan;
	}
	public void setTypeloan(String typeloan) {
		this.typeloan = typeloan;
	}
	@Override
	public String toString() {
		return "Register [id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact + ", pannumber="
				+ pannumber + ", aadharnumber=" + aadharnumber + ", typeloan=" + typeloan + "]";
	}
	
	
	
}
