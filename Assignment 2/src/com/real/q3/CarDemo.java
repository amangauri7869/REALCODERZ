package com.real.q3;

import java.util.Locale.Category;

public class CarDemo {

	public static void main(String[] args) {
		
		Car one=new Car("Honda", "WRV", 5, 1100000);
		Car two=new Car("Hyundai", "Creta", 5, 1950000);
		Car three=new Car("Mercedes-Benz", "E-class", 4, 6200000);
		
		System.out.println(BestCar(one, two, three, 'p'));

	}

  

public static String BestCar(Car one, Car two, Car three, char string) {
		
	   String MakeAndModel="";
	   if(string=='c')
	   {
		   int capacity=Integer.MAX_VALUE;
		   if(one.getPassengerCapacity()<capacity)
		   {
			   capacity=one.getPassengerCapacity();
			   MakeAndModel=one.getMake()+"-"+one.getModel();
		   }
		   if(two.getPassengerCapacity()<capacity)
		   {
			   capacity=two.getPassengerCapacity();
			   MakeAndModel=two.getMake()+"-"+two.getModel();
		   }
		   if(three.getPassengerCapacity()<capacity)
		   {
			   capacity=three.getPassengerCapacity();
			   MakeAndModel=three.getMake()+"-"+three.getModel();
		   }
	   }
	   
	   if(string=='p')
	   {
		   double price=Integer.MAX_VALUE;
		   if(one.getOnRoadPrice()<price)
		   {
			   price=one.getOnRoadPrice();
			   MakeAndModel=one.getMake()+"-"+one.getModel();
		   }
		   if(two.getOnRoadPrice()<price)
		   {
			   price=two.getOnRoadPrice();
			   MakeAndModel=two.getMake()+"-"+two.getModel();
		   }
		   if(three.getOnRoadPrice()<price)
		   {
			   price=three.getOnRoadPrice();
			   MakeAndModel=three.getMake()+"-"+three.getModel();
		   }
	   }
	   
	   
		return MakeAndModel;
	}

}