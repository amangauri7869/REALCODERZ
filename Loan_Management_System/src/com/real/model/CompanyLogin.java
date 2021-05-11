package com.real.model;

public class CompanyLogin {

	private String companyemail;
	private String companypassword;
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
		return "CompanyLogin [companyemail=" + companyemail + ", companypassword=" + companypassword + "]";
	}
	
	
	
	
	
}
