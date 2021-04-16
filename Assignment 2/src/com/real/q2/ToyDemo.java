package com.real.q2;

import java.util.Locale.Category;

public class ToyDemo {

	public static void main(String[] args) {
		
		Toy one=new Toy("mango", "fruits", 40, 10);
		Toy two=new Toy("apple", "fruits", 55, 20);
		Toy three=new Toy("banana", "fruits", 100, 30);
		
		System.out.println(getLeastPriceToy(one, two, three, "fruits"));

	}

	public static String getLeastPriceToy(Toy one, Toy two, Toy three, String category) {
		
		double leastPriceToy= Integer.MAX_VALUE;
		String leastPriceName="";
		
		
		if(one.getCategory().equals(category))
			if(leastPriceToy>(one.getPrice()-one.getDiscount()))
			{
				leastPriceName=one.getName();
			}
		if(two.getCategory().equals(category))
			if(leastPriceToy>(two.getPrice()-two.getDiscount()))
			{
				leastPriceName=two.getName();
			}
		if(three.getCategory().equals(category))
			if(leastPriceToy>(three.getPrice()-three.getDiscount()))
			{
				leastPriceName=three.getName();
			}
		
		return leastPriceName;
	}
}