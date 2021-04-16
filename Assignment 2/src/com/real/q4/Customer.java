package com.real.q4;

public class Customer {
	
	private int custId;
	private int accId;
	private double creditCardCharges;
	public double getCreditCardCharges() {
		return creditCardCharges;
	}
	public void setCreditCardCharges(double creditCardCharges) {
		this.creditCardCharges = creditCardCharges;
	}
	public int getCustId() {
		return custId;
	}
	public int getAccId() {
		return accId;
	}
	public Customer(int custId, int accId, double creditCardCharges) {
		super();
		this.custId = custId;
		this.accId = accId;
		this.creditCardCharges = creditCardCharges;
	}
	
	
	
	
	
}
