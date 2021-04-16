package com.real.q2;

public class Toy {
	
	private String name;
	private String category;
	private double price;
	private double discount;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getName() {
		return name;
	}
	public String getCategory() {
		return category;
	}
	public Toy(String name, String category, double price, double discount) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.discount = discount;
	}
	
	
	
}
