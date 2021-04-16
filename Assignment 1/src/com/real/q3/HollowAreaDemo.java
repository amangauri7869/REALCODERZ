package com.real.q3;
import java.util.*;

public class HollowAreaDemo {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter outer radius");
		double outerRadius=sc.nextDouble();
		System.out.println("enter inner radius");
		double innerRadius=sc.nextDouble();
		
		
		double hollowArea= calculateHollowArea(outerRadius, innerRadius);
		System.out.println("Hollow Area :" +hollowArea);
		
	}

	public static double calculateHollowArea(double outerRadius, double innerRadius) {
		
		double HollowArea=3.14*(outerRadius*outerRadius-innerRadius*innerRadius);
		
		return HollowArea;
	}

}