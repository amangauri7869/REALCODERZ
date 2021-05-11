package com.real.model;

public class Company {
	
	private int companyid;
	private String companyname;
	private String companyaddress;
	private String companypan;
	private String companyaadhar;
	private String companynumber;
	private String companyemail;
	private String companypassword;
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getCompanyaddress() {
		return companyaddress;
	}
	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}
	public String getCompanypan() {
		return companypan;
	}
	public void setCompanypan(String companypan) {
		this.companypan = companypan;
	}
	public String getCompanyaadhar() {
		return companyaadhar;
	}
	public void setCompanyaadhar(String companyaadhar) {
		this.companyaadhar = companyaadhar;
	}
	public String getCompanynumber() {
		return companynumber;
	}
	public void setCompanynumber(String companynumber) {
		this.companynumber = companynumber;
	}
	public String getCompanyemail() {
		return companyemail;
	}
	public void setCompanyemail(String companyemail) {
		this.companyemail = companyemail;
	}
	public String getCompanypassword() {
		return companypassword;
	}
	public void setCompanypassword(String companypassword) {
		this.companypassword = companypassword;
	}
	@Override
	public String toString() {
		return "Company [companyid=" + companyid + ", companyname=" + companyname + ", companyaddress=" + companyaddress
				+ ", companypan=" + companypan + ", companyaadhar=" + companyaadhar + ", companynumber=" + companynumber
				+ ", companyemail=" + companyemail + ", companypassword=" + companypassword + "]";
	}
	
	
	
	
	

}
