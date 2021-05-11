package com.real.model;

public class Loans {
	
	private int id;
	private int companyid;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Loans [id=" + id + ", companyid=" + companyid + ", status=" + status + "]";
	}
	
	

}
